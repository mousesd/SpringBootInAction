package net.homenet

import grails.persistence.Entity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class Reader implements UserDetails {
    String username
    String fullname
    String password

    @Override
    Collection<? extends GrantedAuthority> getAuthorities() {
        Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"))
    }

    @Override
    String getPassword() {
        password
    }

    @Override
    String getUsername() {
        username
    }

    String getFullname() {
        return fullname
    }

    @Override
    boolean isAccountNonExpired() {
        true
    }

    @Override
    boolean isAccountNonLocked() {
        true
    }

    @Override
    boolean isCredentialsNonExpired() {
        true
    }

    @Override
    boolean isEnabled() {
        true
    }
}
