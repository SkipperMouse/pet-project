package com.example.petproject.model;


import com.example.petproject.model.base_entities.AbstractOperation;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
//todo Application doesn't work perhapse because of deal_id in database. We don't have link here
@Entity
@Table(name = "operations")
@Getter
@Setter
public class Operation extends AbstractOperation {
   /* @ElementCollection
    @CollectionTable(name = "users_operations", joinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "user_id")
    @Column(name = "contribution_debt_reduce")
    private Map<User, String> userContributionDebtReduce;
    @ElementCollection
    @CollectionTable(name = "users_operations", joinColumns = @JoinColumn(name = "operation_id", referencedColumnName = "id"))
    @MapKeyColumn(name = "user_id")
    @Column(name = "approvement")
    private Map<User, Approvement> users;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    //fetch has a default value. Optional means that we can't create an operation without Deal
    @JoinColumn(name = "deal_id", referencedColumnName = "id") //deal_id int operation REFERENCES to id at deals
    private Deal deal;*/


    public Operation() {

    }
}


