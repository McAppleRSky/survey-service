package solv.fact.service.auth;

import solv.fact.repository.entity.Person;
import solv.fact.service.person.PersonService;
import solv.fact.service.auth.model.JwtRequest;
import solv.fact.service.auth.model.JwtResponse;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final PersonService personService;
    private final JwtProvider jwtProvider;
    private final Map<String, String> mapLoginRefresh = new ConcurrentHashMap<>();

    @Override
    public JwtResponse login(@NonNull JwtRequest authRequest) {
        final Person person = personService.getByLogin(authRequest.getLogin())
                .orElseThrow(() -> new AuthException("User not found"));
        if (person.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(person);
            final String refreshToken = jwtProvider.generateRefreshToken(person);
            mapLoginRefresh.put(person.getLogin(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Invalid password");
        }
    }

    @Override
    public JwtResponse getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = mapLoginRefresh.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final Person person = personService.getByLogin(login)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(person);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = mapLoginRefresh.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final Person person = personService.getByLogin(login)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(person);
                final String newRefreshToken = jwtProvider.generateRefreshToken(person);
                mapLoginRefresh.put(person.getLogin(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Invalid JWT token");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

}
