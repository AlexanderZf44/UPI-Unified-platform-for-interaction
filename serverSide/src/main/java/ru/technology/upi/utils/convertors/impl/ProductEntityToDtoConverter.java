package ru.technology.upi.utils.convertors.impl;

import org.springframework.stereotype.Component;
import ru.technology.upi.domain.dto.ManufactureDTO;
import ru.technology.upi.domain.dto.ProductDTO;
import ru.technology.upi.domain.entity.ProductEntity;
import ru.technology.upi.utils.convertors.api.BaseEntityToDtoConverter;

@Component(value = "productConverter")
public class ProductEntityToDtoConverter implements BaseEntityToDtoConverter<ProductEntity, ProductDTO> {

    @Override
    public ProductDTO convert(ProductEntity productEntity) {
        ManufactureDTO manufactureDTO = ManufactureDTO.builder()
                .id(productEntity.getManufacture().getId())
                .approved(productEntity.getManufacture().isApproved())
                .name(productEntity.getManufacture().getName())
                .build();

        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .category(productEntity.getCategory())
                .inStock(productEntity.isInStock())
                .quantity(productEntity.getQuantity())
                .cost(productEntity.getCost())
                .manufacture(manufactureDTO)
                .build();
    }
}
