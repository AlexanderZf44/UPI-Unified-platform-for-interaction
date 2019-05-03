package ru.technology.upi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.technology.upi.domain.enums.ProductCategory;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(schema = "upism", name = "product")
public class ProductEntity extends BaseEntity {

    private static final long serialVersionUID = -4580744404398721111L;

    /**
     * ID сущности.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen", sequenceName = "product_id_seq", allocationSize = 1)
    private int id;

    /**
     * Наименование товара.
     */
    @Column
    private String name;

    /**
     * Категория товара.
     */
    @Column
    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;

    /**
     * Производитель товара.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id")
    private ManufactureEntity manufacture;

    /**
     * Флаг имеется ли товар в наличии.
     */
    @Column
    private boolean inStock;

    /**
     * Кол-во товара в наличии у производителя.
     */
    @Column
    private int quantity;

    /**
     * Стоимость товара в рублях.
     */
    @Column
    private double cost;
}
