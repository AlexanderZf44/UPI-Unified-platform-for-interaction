package ru.technology.upi.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Базовая сущность для отображения в БД.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
