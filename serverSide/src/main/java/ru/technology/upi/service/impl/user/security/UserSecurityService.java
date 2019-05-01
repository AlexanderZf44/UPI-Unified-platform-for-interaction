package ru.technology.upi.service.impl.user.security;

import lombok.extern.slf4j.Slf4j;
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

import java.util.*;

/**
 * Сервис для работы авторизационного слоя с пользователем
 */
@Slf4j
@Service("userSecurityService")
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Метод по нахождению пользователя по его username
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) {
        UserEntity user = userRepository.findByUsername(username);

        if (Objects.isNull(user)) {
            log.error(String.format("User with username %s not found", username));
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    /**
     * Метод построения пользователя для аутентификации
     */
    private User buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    /**
     * Метод построения аутентификационных данных для пользователя
     */
    private List<GrantedAuthority> buildUserAuthority(Set<RoleEntity> userRoles) {
        Set<GrantedAuthority> setAuth = new HashSet<>();

        for (RoleEntity userRole : userRoles) {
            setAuth.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        return new ArrayList<>(setAuth);
    }

    /**
     * Метод по нахождению пользователя по его ID
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserById(final String userId) {

        UserEntity user = userRepository.findById(Integer.valueOf(userId))
                .orElseThrow(() -> {
                    log.error(String.format("User with user id %s not found", userId));
                    throw new UserNotFoundException("User not found");
                });

        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }
}
