package ru.technology.upi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.technology.upi.domain.dto.UserDTO;
import ru.technology.upi.service.api.user.UserService;

import java.util.List;

/**
 * Контроллер, необходимый для взаимодейсвия с пользовательской информацией.
 */
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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> listOfUsers() {
        return userService.findAll();
    }

    /**
     * Метод регистрации нового пользователя.
     *
     * @param user новый пользователь системы.
     * @return созданный пользователь.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }
}
