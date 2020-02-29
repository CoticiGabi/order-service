package com.example.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity(name = "Tables")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    @Id
    @GeneratedValue
    private Long tableId;

    private Long numberOfSeats;

    private boolean occupied;

    private boolean reserved;

//    @OneToMany
//    private Long userId;
}
