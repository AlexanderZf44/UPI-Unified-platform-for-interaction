package ru.technology.upi.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum ProductCategory {

    Component("Компоненты"),
    Device("Готовые устройства");

    private final String description;
}
