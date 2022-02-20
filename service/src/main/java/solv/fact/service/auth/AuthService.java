package solv.fact.service.auth;

import solv.fact.service.auth.model.JwtRequest;
import solv.fact.service.auth.model.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest authRequest) ;

    JwtResponse getAccessToken(String refreshToken) ;

    JwtResponse refresh(String refreshToken) ;

    JwtAuthentication getAuthInfo();

}
