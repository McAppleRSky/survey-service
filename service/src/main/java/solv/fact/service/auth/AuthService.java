package solv.fact.service.auth;

import solv.fact.service.auth.model.AuthRequest;
import solv.fact.service.auth.model.TokenResponse;

public interface AuthService {
    TokenResponse login(AuthRequest authRequest);
}
