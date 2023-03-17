package com.example.demo.config;

import com.example.demo.models.entity.enums.UserRoleEnum;
import com.example.demo.repositopy.UserRepository;
import com.example.demo.service.ApplicationUserDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration

public class ApplicationBeanConfiguration {
    private final UserRepository userRepository;

    public ApplicationBeanConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

  @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/","/home","/users/login", "/users/register", "/users/login-error").permitAll()
                .requestMatchers("/home","/create-item-form").authenticated()
                .requestMatchers("/pet-catalog","/music-catalog","house-catalog").permitAll()
                .requestMatchers("/admins").hasRole(UserRoleEnum.ADMIN.name())
                .requestMatchers("/moderator").hasRole(UserRoleEnum.MODERATOR.name())
                .requestMatchers("users/login?error").authenticated()
                .and()
                .formLogin().loginPage("/users/login").permitAll()
                .usernameParameter("userName")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/users/login-error")
                .and()
                .logout().logoutSuccessUrl("/users/logout").logoutSuccessUrl("/home")
                .invalidateHttpSession(true);

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
