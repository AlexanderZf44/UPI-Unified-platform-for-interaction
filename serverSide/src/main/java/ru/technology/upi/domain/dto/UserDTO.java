package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * DTO пользователя системы.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO {

    /**
     * Имя пользователя.
     */
    private String firstName;
    /**
     * Отчество пользователя.
     */
    private String middleName;
    /**
     * Фамилия пользователя.
     */
    private String lastName;
    /**
     * Логин пользователя.
     */
    private String userName;
    /**
     * Пароль пользователя в системе.
     */
    private String password;
    /**
     * Список ролей пользователя.
     */
    private Set roles;
}
