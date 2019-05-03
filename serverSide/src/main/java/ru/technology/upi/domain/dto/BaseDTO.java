package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * Базовый DTO.
 */
@Data
@SuperBuilder
@RequiredArgsConstructor
public abstract class BaseDTO implements Serializable {

    /**
     * ID DTO.
     */
    private int id;
}
