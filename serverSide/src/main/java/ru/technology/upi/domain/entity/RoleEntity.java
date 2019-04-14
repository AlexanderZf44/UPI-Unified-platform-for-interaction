package ru.technology.upi.domain.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Сущность для отображения ролей пользователей в БД.
 */
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
