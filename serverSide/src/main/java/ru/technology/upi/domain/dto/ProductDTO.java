package ru.technology.upi.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.technology.upi.domain.enums.ProductCategory;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends BaseDTO {

    private static final long serialVersionUID = 2950672268267923870L;

    /**
     * Наименование товара.
     */
    private String name;

    /**
     * Категория товара.
     */
    private ProductCategory category;

    /**
     * Производитель товара.
     */
    private ManufactureDTO manufacture;

    /**
     * Флаг имеется ли товар в наличии.
     */
    private boolean inStock;

    /**
     * Кол-во товара в наличии у производителя.
     */
    private int quantity;

    /**
     * Стоимость товара в рублях.
     */
    private double cost;
}
