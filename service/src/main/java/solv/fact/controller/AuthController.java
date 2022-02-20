package solv.fact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import solv.fact.service.auth.AuthService;
import solv.fact.service.auth.model.JwtRequest;
import solv.fact.service.auth.model.JwtResponse;
import solv.fact.service.auth.model.RefreshJwtRequest;

@Controller
//@RequestMapping("/api/0.0.1/login")
@RequiredArgsConstructor
public class AuthController implements AuthServletable {

    private final AuthService authService;

    @PostMapping("/api/0.0.1/login")
    @Override
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/api/0.0.1/token")
    @Override
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/api/0.0.1/refresh")
    @Override
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}

interface AuthServletable {
    ResponseEntity
        login(JwtRequest authRequest);
    ResponseEntity
        getNewAccessToken(RefreshJwtRequest request);
    ResponseEntity
        getNewRefreshToken(RefreshJwtRequest request);
}
