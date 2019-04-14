package ru.technology.upi.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Базовая сущность для отображения в БД.
 */
@Data
@Entity
public abstract class BaseEntity {

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
