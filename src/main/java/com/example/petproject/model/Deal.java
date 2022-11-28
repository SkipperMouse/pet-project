package com.example.petproject.model;


import com.example.petproject.model.base_entities.AbstractOperation;
import com.example.petproject.model.link_entities.UserDeal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "deals")
@Getter
@Setter
public class Deal extends AbstractOperation {
    @Column(name = "date_time_of_last_operation")
    private LocalDateTime dateTimeOfLastOperation;

    @OneToMany(mappedBy = "deal", fetch = FetchType.EAGER)
    private List<Operation> operations;

    @OneToMany(mappedBy = "deal")
    private List<UserDeal> usersList;

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
