package ru.technology.upi.service.api;

import ru.technology.upi.domain.dto.UserDTO;

import java.util.List;

/**
 * Интерфейс сервиса взаимодействия с пользовательской ифнормацией.
 */
public interface UserService {

    /**
     * Метод сохранения нового пользователя в системе.
     * @param user новый пользователей.
     * @return созданный пользователь.
     */
    UserDTO save(UserDTO user);

    /**
     * Метод нахождения всех пользователей системы.
     * @return список пользователей системы.
     */
    List<UserDTO> findAll();

    /**
     * Метод удаления пользователя системы по его ID.
     * @param id ID пользователя
     * @return флаг успешного удаления пользователя.
     */
    boolean delete(long id);

    /**
     * Метод для нахождения пользователя по его логину в системе.
     * @param userName логин пользователя в системе.
     * @return DTO пользователя.
     */
    UserDTO find(String userName);

    /**
     * Метод для нахождения пользователя по его ID в системе.
     * @param id ID пользователя в системе.
     * @return DTO пользователя.
     */
    UserDTO find(Long id);
}
