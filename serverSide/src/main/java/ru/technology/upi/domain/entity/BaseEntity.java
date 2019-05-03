package ru.technology.upi.domain.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Базовая сущность для отображения в БД.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /*
     * ID сущности перенесены в свои сущности для sequence генерации.
     * Класс остается для дальнейшего внедрения версионности.
     */
}
