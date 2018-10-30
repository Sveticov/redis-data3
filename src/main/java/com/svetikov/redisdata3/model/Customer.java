package com.svetikov.redisdata3.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter

@ToString
public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    private long id;
    private String firstName;
    private String lastName;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {
    }
}
