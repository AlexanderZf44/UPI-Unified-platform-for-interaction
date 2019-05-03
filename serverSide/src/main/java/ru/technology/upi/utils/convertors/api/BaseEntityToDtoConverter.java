package ru.technology.upi.utils.convertors.api;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.technology.upi.domain.dto.BaseDTO;
import ru.technology.upi.domain.entity.BaseEntity;

@Component
public interface BaseEntityToDtoConverter<S extends BaseEntity, T extends BaseDTO> extends Converter<S, T> {
}
