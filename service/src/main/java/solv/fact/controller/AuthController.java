package solv.fact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import solv.fact.service.auth.AuthService;
import solv.fact.service.auth.model.AuthRequest;
import solv.fact.service.auth.model.TokenResponse;

@Controller
@RequestMapping("/api/0.0.1/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<TokenResponse> login(AuthRequest authRequest) {
        final TokenResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

}
