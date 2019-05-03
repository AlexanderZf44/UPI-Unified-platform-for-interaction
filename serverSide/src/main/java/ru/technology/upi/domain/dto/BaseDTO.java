package ru.technology.upi.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Базовый DTO.
 */
@Data
public abstract class BaseDTO implements Serializable {

    /**
     * ID DTO.
     */
    private int id;
}
