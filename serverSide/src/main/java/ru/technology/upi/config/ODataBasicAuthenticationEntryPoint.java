package ru.technology.upi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ODataBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Value("${odata.authentication.header.name}")
    private String odataHeaderName;
    @Value("${odata.authentication.header.value}")
    private String odataHeaderValue;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.addHeader(odataHeaderName, odataHeaderValue);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("Authorization 401");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("REALM");
        super.afterPropertiesSet();
    }
}
