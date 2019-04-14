package ru.technology.upi.service.impl;

import org.springframework.stereotype.Service;
import ru.technology.upi.domain.dto.UserDTO;
import ru.technology.upi.service.api.UserService;

import java.util.List;

/**
 * Реализация сервиса взаимодействия с пользовательской ифнормацией.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    /**
     * Метод сохранения нового пользователя в системе.
     * @param user новый пользователей.
     * @return созданный пользователь.
     */
    @Override
    public UserDTO save(UserDTO user) {
        return null;
    }

    /**
     * Метод нахождения всех пользователей системы.
     * @return список пользователей системы.
     */
    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    /**
     * Метод удаления пользователя системы по его ID.
     * @param id ID пользователя
     * @return флаг успешного удаления пользователя.
     */
    @Override
    public boolean delete(long id) {
        return false;
    }

    /**
     * Метод для нахождения пользователя по его логину в системе.
     * @param userName логин пользователя в системе.
     * @return DTO пользователя.
     */
    @Override
    public UserDTO find(String userName) {
        return null;
    }

    /**
     * Метод для нахождения пользователя по его ID в системе.
     * @param id ID пользователя в системе.
     * @return DTO пользователя.
     */
    @Override
    public UserDTO find(Long id) {
        return null;
    }
}
