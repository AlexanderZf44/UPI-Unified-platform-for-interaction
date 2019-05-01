package ru.technology.upi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Сущность для отображения пользователя в БД.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "upism", name = "user")
public class UserEntity extends BaseEntity {

    /**
     * Имя пользователя.
     */
    @Column
    private String firstName;
    /**
     * Отчество пользователя.
     */
    @Column
    private String middleName;
    /**
     * Фамилия пользователя.
     */
    @Column
    private String lastName;
    /**
     * Логин пользователя в системе.
     */
    @Column
    private String username;
    /**
     * Пароль пользователя в системе.
     */
    @Column
    private String password;
    /**
     * Список ролей пользователя в системе.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(schema = "upism", name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<RoleEntity> roles;
}
