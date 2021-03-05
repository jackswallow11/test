package com.crud.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String category;
    private String funders;
    private int fund_target;
    private String description;


}
