package com.digitalinnovation.ecommercecheckout.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder
@Data
@Entity
public class Checkout {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String code;

    @Column
    @Enumerated (value = EnumType.STRING)
    private Status status;

    public enum Status {
        CREATED,
        APPROVED
    }


}
