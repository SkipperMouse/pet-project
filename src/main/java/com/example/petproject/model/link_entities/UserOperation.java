package com.example.petproject.model.link_entities;

import com.example.petproject.model.Operation;
import com.example.petproject.model.User;
import com.example.petproject.model.base_entities.BaseEntity;
import com.example.petproject.model.enums.Approvement;
import com.example.petproject.model.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_operation")
@Getter
@Setter
public class UserOperation {
    @Id
    @SequenceGenerator(name = "user_operation_generator", sequenceName = "user_operation_seq", allocationSize = 1, initialValue = BaseEntity.START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_operation_generator")
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "approvement")
    private Approvement approvement;

    @Column(name = "contribution")
    private Double contribution;

    @Column(name = "debt")
    private Double debt;

    @Column(name = "reduce")
    private Double reduce;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "operation_id", referencedColumnName = "id")
    private Operation operation;

    public UserOperation() {
    }
}
