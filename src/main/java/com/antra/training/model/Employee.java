package com.antra.training.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String EmployeeName;

    @Column(name = "first_name")
    private String FirstName;
//
//    public Date getHiredDate() {
//        return HiredDate;
//    }

//    public void setHiredDate(Date hiredDate) {
//        HiredDate = hiredDate;
//    }

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String Email;

    @Column(name = "address")
    private String Address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
//    @Column(name = "hired_date")
//    private Date HiredDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    //mappedby-->去Account里边找那个"emp"
    //Cascade--> 解决删除和更新之间的关系，
    private Set<Account> accounts;

    @OneToMany(mappedBy = "dep", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Department> departments;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
