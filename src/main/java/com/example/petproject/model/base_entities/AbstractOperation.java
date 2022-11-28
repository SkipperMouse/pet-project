package com.example.petproject.model.base_entities;


import com.example.petproject.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractOperation extends BaseEntity{

    @Column(name = "name")
    @NotBlank
    protected String name;
    @NotNull
    @Column(name = "date_time")
    protected LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "status")
    protected Status status;
    @Column(name = "sum")
    protected int sum;
    @Column(name = "currency")
    protected int currency;



    public AbstractOperation() {
    }

    public boolean isNew(){
        return id == null || id ==0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractOperation that)) return false;
        if (!super.equals(o)) return false;
        return getSum() == that.getSum() && getCurrency() == that.getCurrency() && getName().equals(that.getName()) && getDateTime().equals(that.getDateTime()) && getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getDateTime(), getStatus(), getSum(), getCurrency());
    }
}
