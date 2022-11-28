package com.example.petproject.model.link_entities;

import com.example.petproject.model.Deal;
import com.example.petproject.model.User;
import com.example.petproject.model.enums.Approvement;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "users_deals")
@Getter
@Setter
@ToString
public class UserDeal {
    @Id
    @SequenceGenerator(name = "user_deal_generator", sequenceName = "user_deal_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_deal_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "approvement")
    @Enumerated(value = EnumType.STRING)
    private Approvement approvement;

    @Column(name = "balance")
    private int balance;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "deal_id", referencedColumnName = "id")
    private Deal deal;

    public UserDeal() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserDeal userDeal = (UserDeal) o;
        return id != null && Objects.equals(id, userDeal.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
