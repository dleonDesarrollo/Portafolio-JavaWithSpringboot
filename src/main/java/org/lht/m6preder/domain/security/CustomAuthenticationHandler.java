package org.lht.m6preder.domain.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationHandler implements AuthenticationSuccessHandler {

  SimpleUrlAuthenticationSuccessHandler clienteSuccessHandler =
          new SimpleUrlAuthenticationSuccessHandler("/resumen/cliente");
  SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
          new SimpleUrlAuthenticationSuccessHandler("/resumen/administrativo");
  SimpleUrlAuthenticationSuccessHandler profeSuccessHandler =
          new SimpleUrlAuthenticationSuccessHandler("/resumen/profesional");

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException, ServletException {

    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (final GrantedAuthority grantedAuthority : authorities) {
      String authorityName = grantedAuthority.getAuthority();
      if (authorityName.equals("ROLE_ADMIN")) {
        this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        return;
      }
      if (authorityName.equals("ROLE_CLIENTE")) {
        this.clienteSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        return;
      }
      if (authorityName.equals("ROLE_PROFE")) {
        this.profeSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        return;
      }
    }
  }
}
