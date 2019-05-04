package ru.technology.upi.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.technology.upi.domain.dto.ProductDTO;
import ru.technology.upi.domain.entity.ProductEntity;
import ru.technology.upi.repository.ProductRepository;
import ru.technology.upi.service.api.product.ProductService;
import ru.technology.upi.utils.convertors.api.BaseEntityToDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация сервиса взаимодействия с товарами на платформе.
 */
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    @Qualifier("productConverter")
    private BaseEntityToDtoConverter<ProductEntity, ProductDTO> converter;

    /**
     * Метод сохранения нового товара в системе.
     *
     * @param product новый товар.
     * @return созданный товар.
     */
    @Override
    public ProductDTO save(ProductDTO product) {
        return null;
    }

    /**
     * Метод нахождения всех товаров на платформе.
     *
     * @return список товаров на платформе.
     */
    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> dbProducts = repository.findAll();

        return dbProducts.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Метод удаления товара из системы по его ID.
     *
     * @param id ID товара
     * @return флаг успешного удаления товара.
     */
    @Override
    public boolean delete(long id) {
        return false;
    }

    /**
     * Метод для нахождения товара по его наименованию в системе.
     *
     * @param productName наименование товара в системе.
     * @return DTO товара.
     */
    @Override
    public ProductDTO find(String productName) {
        return null;
    }

    /**
     * Метод для нахождения товара по его ID в системе.
     *
     * @param id ID товара в системе.
     * @return DTO товара.
     */
    @Override
    public ProductDTO find(Long id) {
        return null;
    }

    /**
     * Метод для нахождения списка товаров по их ID в системе.
     *
     * @param productIds список ID необходимых товаров.
     * @return список DTO товаров.
     */
    @Override
    public List<ProductDTO> findAllByIds(List<Integer> productIds) {
        List<ProductEntity> dbProducts = repository.findAllById(productIds);

        return dbProducts.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
