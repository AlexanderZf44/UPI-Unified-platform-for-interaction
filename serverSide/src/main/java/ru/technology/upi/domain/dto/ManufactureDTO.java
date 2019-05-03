package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * DTO для производителя электроники.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ManufactureDTO extends BaseDTO {

    private static final long serialVersionUID = 8075069556378619436L;

    /**
     * Наименование производителя электроники.
     */
    private String name;

    /**
     * Признак подтвержден ли производитель на платформе.
     */
    private boolean approved;

    /**
     * Основная информация пользователя в системе.
     */
    private UserDTO userInfo;

    /**
     * Список товаров производителя на платформе.
     */
    private List<ProductDTO> products;
}
