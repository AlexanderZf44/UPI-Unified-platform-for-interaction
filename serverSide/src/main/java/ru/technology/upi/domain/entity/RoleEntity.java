package ru.technology.upi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Сущность для отображения ролей пользователей в БД.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "upism", name = "role")
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = -1162222681315847888L;

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_gen")
    @SequenceGenerator(name = "role_id_gen", sequenceName = "role_id_seq", allocationSize = 1)
    private int id;

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
