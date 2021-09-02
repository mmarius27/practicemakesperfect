package ac.practicemakesperfect.practicemakesperfect.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ac.practicemakesperfect.practicemakesperfect.config.AuthenticationConfigConstants;
import ac.practicemakesperfect.practicemakesperfect.model.UserCreds;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override 
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = null;
        String password = null;
        username = request.getParameter("username");
        password = request.getParameter("password");

        Authentication ret=null;
        try {
            ret = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch(Exception e){
            System.out.println("EROAREA:" + e.getMessage());
            throw e;
        }
        return ret;
    }

    @Override 
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
            .withSubject(((UserCreds) auth.getPrincipal()).getUsername())
            .withClaim("role", auth.getAuthorities().iterator().next().getAuthority())
            .withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConfigConstants.EXPIRATION_TIME))
            .sign(Algorithm.HMAC512(AuthenticationConfigConstants.SECRET.getBytes()));

        //START - SENDING JWT AS A BODY
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(
            "{\"" + AuthenticationConfigConstants.HEADER_STRING + "\":\"" + AuthenticationConfigConstants.TOKEN_PREFIX + token + "\"}"
        );
        //END - SENDING JWT AS A BODY

        //START - SENDING JWT AS A HEADER
        response.addHeader(AuthenticationConfigConstants.HEADER_STRING, AuthenticationConfigConstants.TOKEN_PREFIX + token);
        //END - SENDING JWT AS A HEADER
    }
}
