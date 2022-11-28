package com.example.petproject.model;


import com.example.petproject.model.base_entities.AbstractOperation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "deals")
@Getter
@Setter
public class Deal extends AbstractOperation {
    @Column(name = "date_time_of_last_operation")
    private LocalDateTime dateTimeOfLastOperation;

  /*  @OneToMany(mappedBy = "deal", fetch = FetchType.LAZY)  //link to Operation field "deal". fetch has a default value
    private List<Operation> operations;

    @OneToMany(mappedBy = "deal", fetch = FetchType.LAZY)
    private List<UserDeal> userDeals;*/


    public Deal() {
    }

    public LocalDateTime getDateTimeOfLastOperation() {
        return dateTimeOfLastOperation;
    }

    public void setDateTimeOfLastOperation(LocalDateTime dateTimeOfLastOperation) {
        this.dateTimeOfLastOperation = dateTimeOfLastOperation;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", sum=" + sum +
                ", currency=" + currency +
                ", dateTimeOfLastOperation=" + dateTimeOfLastOperation +
                '}';
    }

}
