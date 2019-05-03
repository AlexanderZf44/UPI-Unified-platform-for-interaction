package ru.technology.upi.service.api.product;

import ru.technology.upi.domain.dto.ProductDTO;

import java.util.List;

/**
 * Интерфейс сервиса взаимодействия с товарами на платформе.
 */
public interface ProductService {

    /**
     * Метод сохранения нового товара в системе.
     *
     * @param product новый товар.
     * @return созданный товар.
     */
    ProductDTO save(ProductDTO product);

    /**
     * Метод нахождения всех товаров на платформе.
     *
     * @return список товаров на платформе.
     */
    List<ProductDTO> findAll();

    /**
     * Метод удаления товара из системы по его ID.
     *
     * @param id ID товара
     * @return флаг успешного удаления товара.
     */
    boolean delete(long id);

    /**
     * Метод для нахождения товара по его наименованию в системе.
     *
     * @param productName наименование товара в системе.
     * @return DTO товара.
     */
    ProductDTO find(String productName);

    /**
     * Метод для нахождения товара по его ID в системе.
     *
     * @param id ID товара в системе.
     * @return DTO товара.
     */
    ProductDTO find(Long id);
}
