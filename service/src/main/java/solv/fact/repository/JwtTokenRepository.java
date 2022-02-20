package solv.fact.repository;

import javax.servlet.http.HttpServletResponse;

public interface JwtTokenRepository {

    void clearToken(HttpServletResponse response);

}
