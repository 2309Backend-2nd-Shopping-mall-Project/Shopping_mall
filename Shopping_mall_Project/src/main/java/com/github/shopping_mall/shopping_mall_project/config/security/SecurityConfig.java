package com.github.shopping_mall.shopping_mall_project.config.security;


import com.github.shopping_mall.shopping_mall_project.web.filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers(h->h.frameOptions(f->f.sameOrigin()))
                .csrf((c)->c.disable())
                .httpBasic(h->h.disable())
                .formLogin(f->f.disable())
//                .oauth2Login(o->o.loginPage("/api/account/login"))
                .rememberMe(r->r.disable())
//                .cors(c->{
//                    c.configurationSource(corsConfigurationSource());
//                })
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(e->{
                    e.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
                    e.accessDeniedHandler(new CustomAccessDeniedHandler());
                })
                .authorizeRequests(a ->
                        a
                                .requestMatchers("/resources/static/**", "/api/sign/*").permitAll()
                                .requestMatchers("/admin/**", "/api/account/set-super-user","/api/customer/*").hasAnyRole("ADMIN","SUPERUSER")
                                .requestMatchers("/api/v1/user/logout").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                                .requestMatchers("/api/account/**").hasAnyRole("ADMIN", "SUPERUSER", "USER")

                )
//                .logout(l-> {
//                    l.logoutRequestMatcher(new AntPathRequestMatcher("/api/account/logout"));
//                    l.logoutSuccessUrl("/api/account/login");
//                    l.invalidateHttpSession(true);
//
//                })
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
