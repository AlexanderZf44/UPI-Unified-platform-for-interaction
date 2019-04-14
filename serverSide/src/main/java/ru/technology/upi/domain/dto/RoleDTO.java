package ru.technology.upi.domain.dto;

import lombok.Data;

/**
 * DTO ролей пользователя в системе.
 */
@Data
public class RoleDTO extends BaseDTO {

    /**
     * Название роли в системе.
     */
    private String name;
    /**
     * Описание роли.
     */
    private String description;
}
