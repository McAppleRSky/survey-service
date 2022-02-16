package solv.fact.service.auth.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenResponse {

    private final String type = "token";
    private final String accessToken;

}
