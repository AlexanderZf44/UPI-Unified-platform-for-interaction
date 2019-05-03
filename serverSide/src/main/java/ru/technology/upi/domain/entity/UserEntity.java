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

    private static final long serialVersionUID = 151988851799588287L;

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
    private int id;

    /**
     * Имя пользователя.
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * Отчество пользователя.
     */
    @Column(name = "middle_name")
    private String middleName;
    /**
     * Фамилия пользователя.
     */
    @Column(name = "last_name")
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
