package net.homenet

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration)
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").access("hasRole('READER')")
            .antMatchers("/**").permitAll()
        .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true")
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //# 아래 예외가 발생
        //# - 발생되는 원인은 알수 없고, 예상되는 원인은 gorm 관련 원인인거 같음...
        //# Caused by: groovy.lang.MissingMethodException:
        //  No signature of method: static net.homenet.Reader.findByUsername() is applicable for argument types: (String) values: [craig]
        auth.userDetailsService({ username -> Reader.findByUsername(username) } as UserDetailsService)
    }
}
