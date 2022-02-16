package solv.fact.service.auth;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;
import solv.fact.service.auth.model.AuthRequest;
import solv.fact.service.auth.model.TokenResponse;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public TokenResponse login(AuthRequest authRequest) {
        throw new NotImplementedException("Login not implemented");
    }

}
