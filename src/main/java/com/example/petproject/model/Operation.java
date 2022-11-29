package com.example.petproject.model;


import com.example.petproject.model.base_entities.AbstractOperation;
import com.example.petproject.model.link_entities.UserOperation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "operations")
@Getter
@Setter
public class Operation extends AbstractOperation {

    @ManyToOne
    @JoinColumn(name = "deal_id", referencedColumnName = "id")
    private Deal deal;

    @OneToMany(mappedBy = "operation")
    private List<UserOperation> users;

    public Operation() {

    }
}


