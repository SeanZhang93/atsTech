package com.antra.training.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    @Column(name = "first_name")
    private String FirstName;


    @Column(name = "last_name")
    private String LastName;


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(FirstName, user.FirstName) &&
                Objects.equals(LastName, user.LastName) &&
                Objects.equals(Email, user.Email) &&
                Objects.equals(secretKey, user.secretKey) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FirstName, LastName, Email, secretKey, password);
    }

    @Column(name = "email")
    private String Email;

    @Column(name = "name")
    private String secretKey;

    @Column(name = "column")
    private String password;


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(name = "users_role",
//                joinColumns = {@JoinColumn(name = "user_id")},
//    inverseJoinColumns = {@JoinColumn(name = "role_id")})
//
//    private Set roles; //why set, it performs better
//
//    public void addRole(Role role) {
//        this.roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void removeRole(Role role) {
//        this.roles.remove(role);
//        role.getUsers().remove(this);
//    }
}
