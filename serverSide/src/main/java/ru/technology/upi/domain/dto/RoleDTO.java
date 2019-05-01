package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO ролей пользователя в системе.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
