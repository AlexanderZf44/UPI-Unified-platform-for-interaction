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

    private static final long serialVersionUID = 4571302120147186231L;

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
     * Email пользователя системы.
     */
    private String email;

    /**
     * Телефон пользователя системы.
     */
    private String phone;

    /**
     * Адрес пользователя системы.
     */
    private String address;

    /**
     * Список ролей пользователя.
     */
    private Set<RoleDTO> roles;

    /**
     * Данные производителя электроники, если пользователь является производителем.
     */
    private ManufactureDTO manufacture;
}
