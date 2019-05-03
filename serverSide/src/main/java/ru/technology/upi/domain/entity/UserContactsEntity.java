package ru.technology.upi.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Сущность контактных данных пользователя системы.
 */
@Data
@Embeddable
public class UserContactsEntity {

    /**
     * Email пользователя системы.
     */
    @Column
    private String email;

    /**
     * Телефон пользователя системы.
     */
    @Column
    private String phone;

    /**
     * Адрес пользователя системы.
     */
    @Column
    private String address;
}
