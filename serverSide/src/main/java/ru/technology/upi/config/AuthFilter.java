package ru.technology.upi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.technology.upi.service.exception.UserNotFoundException;
import ru.technology.upi.service.impl.user.security.UserSecurityService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Component
public class AuthFilter extends GenericFilterBean {

    @Autowired
    @Qualifier("userSecurityService")
    private UserSecurityService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (Objects.nonNull(httpRequest.getUserPrincipal())) {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            String userId = httpRequest.getUserPrincipal().getName();

            UserDetails user;
            try {
                user = userService.loadUserById(userId);
            } catch (UserNotFoundException e) {
                user = userService.loadUserByUsername(userId);
            }
            Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
            securityContext.setAuthentication(auth);
            httpRequest.getSession(true).setAttribute(SPRING_SECURITY_CONTEXT_KEY, securityContext);
        }
        chain.doFilter(httpRequest, response);
    }

    @Override
    public void destroy() {
    }
}
