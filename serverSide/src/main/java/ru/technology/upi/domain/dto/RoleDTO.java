package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO ролей пользователя в системе.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends BaseDTO {

    private static final long serialVersionUID = -5997144296089523348L;

    /**
     * Название роли в системе.
     */
    private String name;
    /**
     * Описание роли.
     */
    private String description;
}
