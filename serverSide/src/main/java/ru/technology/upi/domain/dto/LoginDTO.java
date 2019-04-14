package ru.technology.upi.domain.dto;

import lombok.Data;

/**
 * DTO для обработки аутентификации пользователя.
 */
@Data
public class LoginDTO {

    /**
     * Логин пользователя в системе.
     */
    private String username;

    /**
     * Пароль пользователя в системе.
     */
    private String password;
}
