package com.example.petproject.model;


import com.example.petproject.model.base_entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(name = "login")
    private String login;
    @NotBlank
    @Size(min = 8, max = 50)
    @Column(name = "password")
    private String password;
    @NotNull
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "nickname")
    private String nickName;
    @NotNull
    @Column(name = "registered")
    private LocalDateTime registered;
    @Column(name = "balance")
    private Integer balance;



    /*   @OneToMany()
    @JoinTable(name = "contacts",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "id"))
    private List<User> contacts;
    @ManyToMany()
    @JoinTable(name = "users_deals",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "deal_id", referencedColumnName = "id"))
    private List<Deal> deals;

    */


    public User(Long id, String login, String password, String email, String name, String surname, String nickName, LocalDateTime registered) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.registered = registered;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", registered=" + registered +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getLogin().equals(user.getLogin()) && getEmail().equals(user.getEmail()) && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getNickName(), user.getNickName()) && getRegistered().equals(user.getRegistered()) && Objects.equals(getBalance(), user.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getEmail(), getName(), getSurname(), getNickName(), getRegistered(), getBalance());
    }
}
