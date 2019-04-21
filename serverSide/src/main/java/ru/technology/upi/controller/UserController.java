package ru.technology.upi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.technology.upi.domain.dto.UserDTO;
import ru.technology.upi.service.api.user.UserService;

import java.util.List;

/**
 * Контроллер, необходимый для взаимодейсвия с пользовательской информацией.
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Метод для получения списка пользователей,
     * доступный только для администратора системы.
     *
     * @return список пользователей системы.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/all")
    public List<UserDTO> listOfUsers() {
        return userService.findAll();
    }

    /**
     * Метод регистрации нового пользователя.
     *
     * @param user новый пользователь системы.
     * @return созданный пользователь.
     */
    @PostMapping(value = "/register")
    public UserDTO saveUser(@RequestBody UserDTO user) {
        log.info("New user register " + user.getUserName());
        return userService.save(user);
    }

    /**
     * Метод для обозначения авторизации пользователя.
     *
     * @param user пользователь
     * @return пользователь
     */
    @PostMapping(value = "/login")
    public UserDTO loginUser(UserDTO user) {
        log.info("Login user " + user.getUserName());
        return user;
    }
}
