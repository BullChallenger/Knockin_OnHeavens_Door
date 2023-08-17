package com.knockin.door.knockin_onheavens_door.util;

import com.knockin.door.knockin_onheavens_door.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

@Component
public class RoleUtil {
    public Set<GrantedAuthority> addAuthoritiesForContext(UserEntity targetUser) {
        String role = targetUser.getRole().name();

        Set<GrantedAuthority> authorities = new HashSet<>();

        Assert.isTrue(!role.startsWith("ROLE_"),
                () -> role + " cannot start with ROLE_ (it is automatically added)");
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

        return authorities;
    }
}
