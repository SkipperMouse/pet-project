package com.example.petproject.model.link_entities;

import com.example.petproject.model.User;
import com.example.petproject.model.base_entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {
    @Id
    @SequenceGenerator(name = "contacts_generator", sequenceName = "contact_seq", initialValue = BaseEntity.START_SEQ, allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    public User contact;

    public Contact(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return getId().equals(contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
