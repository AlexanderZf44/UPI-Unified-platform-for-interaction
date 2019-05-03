package ru.technology.upi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность для производителя электроники.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "upism", name = "manufacture")
public class ManufactureEntity extends BaseEntity {

    private static final long serialVersionUID = -445621716759668899L;

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacture_id_gen")
    @SequenceGenerator(name = "manufacture_id_gen", sequenceName = "manufacture_id_seq", allocationSize = 1)
    private int id;

    /**
     * Наименование производителя электроники.
     */
    @Column
    private String name;

    /**
     * Признак подтвержден ли производитель на платформе.
     */
    @Column
    private boolean approved;

    /**
     * Основная информация пользователя в системе.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userInfo;

    /**
     * Список товаров производителя на платформе.
     */
    @OneToMany(mappedBy = "manufacture", orphanRemoval = true)
    private List<ProductEntity> products;
}
