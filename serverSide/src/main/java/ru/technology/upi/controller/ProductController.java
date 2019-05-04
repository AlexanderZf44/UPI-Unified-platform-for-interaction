package ru.technology.upi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.technology.upi.domain.dto.ProductDTO;
import ru.technology.upi.service.api.product.ProductService;

import java.util.List;

/**
 * Контроллер, необходимый для взаимодейсвия с товарами платформы.
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Метод для получения списка товаров на платформе.
     *
     * @return список товаров на платформе.
     */
    @GetMapping(value = "/all")
    public List<ProductDTO> listOfProducts() {
        return productService.findAll();
    }

    /**
     * Метод для нахождения списка товаров по их ID в системе.
     *
     * @param productIds список ID необходимых товаров.
     * @return список DTO товаров.
     */
    @GetMapping(value = "/{productIds}")
    public List<ProductDTO> findAllByIds(@PathVariable List<Integer> productIds) {
        return productService.findAllByIds(productIds);
    }

    /**
     * Метод создания нового товара.
     *
     * @param product новый товар на платформе.
     * @return созданный товар.
     */
    @PostMapping(value = "/save")
    public ProductDTO saveUser(@RequestBody ProductDTO product) {
        log.info("New product save " + product.getName());
        return productService.save(product);
    }
}
