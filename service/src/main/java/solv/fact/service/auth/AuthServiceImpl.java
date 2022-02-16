package solv.fact.service.auth;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.repository.PersonRepository;
import solv.fact.service.auth.model.AuthRequest;
import solv.fact.service.auth.model.TokenResponse;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final PersonRepository personRepository;

    @Override
    public TokenResponse login(AuthRequest authRequest) {
        throw new NotImplementedException("Login not implemented");
    }

}
