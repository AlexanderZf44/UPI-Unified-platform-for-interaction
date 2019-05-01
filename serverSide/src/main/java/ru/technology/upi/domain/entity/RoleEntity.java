package ru.technology.upi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Сущность для отображения ролей пользователей в БД.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "upism", name = "role")
public class RoleEntity extends BaseEntity {

    /**
     * Название роли в системе.
     */
    @Column
    private String name;
    /**
     * Описание роли.
     */
    @Column
    private String description;
}
