package com.example.petproject.model.base_entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Persistable<Long> {
    public static final int START_SEQ = 1000;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "global_generator", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_generator")
    protected Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean isNew() {
        return id == null || id == 0;
    }
}
