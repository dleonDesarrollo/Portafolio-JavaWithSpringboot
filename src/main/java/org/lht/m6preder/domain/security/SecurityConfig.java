package org.lht.m6preder.domain.security;

import lombok.RequiredArgsConstructor;
import org.lht.m6preder.web.filter.JwtFilterRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final JwtFilterRequest jwtFilterRequest;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {


    http = http
            .csrf()
            .disable();

//    http = http
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and();

    //Se podria crear un ADMIN en memoria para no tener que insertar uno en  la base de datos constantemente
    http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(HttpMethod.GET, "/api/users").permitAll()
            .antMatchers(HttpMethod.POST, "/api/user/save").permitAll()
            .antMatchers(HttpMethod.POST, "/api/customer/save").permitAll()
            .antMatchers(HttpMethod.POST, "/api/manager/save").permitAll()
            .antMatchers(HttpMethod.POST, "/api/professional/save").permitAll()
            .antMatchers("/**/cliente/**").hasRole("CLIENTE")
            .antMatchers("/**/administrativo/**").hasRole("ADMIN")
            .antMatchers("/**/profesional/**").hasRole("PROFE")
            .anyRequest().authenticated()
            .and()
            .formLogin(formLogin -> formLogin.successHandler(new CustomAuthenticationHandler()))
            .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
            .and()
            .logout().permitAll();


    http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/img/**");
  }


  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }


}
