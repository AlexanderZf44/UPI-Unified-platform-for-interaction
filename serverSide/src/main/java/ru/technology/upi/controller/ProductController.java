package ru.technology.upi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.technology.upi.domain.dto.ProductDTO;
import ru.technology.upi.domain.dto.UserDTO;
import ru.technology.upi.service.api.product.ProductService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
