package ru.technology.upi.service.impl.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.technology.upi.domain.entity.RoleEntity;
import ru.technology.upi.domain.entity.UserEntity;
import ru.technology.upi.repository.UserRepository;
import ru.technology.upi.service.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service("userSecurityService")
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) {
        UserEntity user = userRepository.findByUsername(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(
            UserEntity user,
            List<GrantedAuthority> authorities
    ) {
        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    private List<GrantedAuthority> buildUserAuthority(Set<RoleEntity> userRoles) {
        Set<GrantedAuthority> setAuth = new HashSet<>();

        for (RoleEntity userRole : userRoles) {
            setAuth.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        return new ArrayList<>(setAuth);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserById(final String userId) {

        UserEntity user = userRepository.findById(Integer.valueOf(userId))
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }
}
