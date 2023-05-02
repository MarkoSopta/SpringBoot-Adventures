package com.marko.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
/**
 * This is an enum class that defines the two different roles a user can have. 
 * The two roles are USER and ADMIN. 
 */
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(Set.of(Perms.ADMIN_READ,
            Perms.ADMIN_UPDATE,
            Perms.ADMIN_DELETE,
            Perms.ADMIN_CREATE,
            Perms.MANAGER_READ,
            Perms.MANAGER_UPDATE,
            Perms.MANAGER_DELETE,
            Perms.MANAGER_CREATE)),
    MANAGER(Set.of(Perms.MANAGER_READ,
            Perms.MANAGER_UPDATE,
            Perms.MANAGER_DELETE,
            Perms.MANAGER_CREATE));
    @Getter
    private final Set<Perms> permissions;

    public List<SimpleGrantedAuthority> getUserAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(perms -> new SimpleGrantedAuthority(perms.getPerm()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
