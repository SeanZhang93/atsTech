package com.antra.training.model;


import javax.persistence.*;

import java.util.Set;

import java.lang.Integer;
import static javax.persistence.GenerationType.SEQUENCE;


//todo: add column @ to hibernate
@Entity
@Table(name = "departments")
public class Department {
   // public Department(){};

//    @Id
////    @GeneratedValue(strategy=SEQUENCE, generator = "users_id_seq")
////    @SequenceGenerator(name="users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
//    private long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;


//    @Column(name = "department_name")
//    private String departmentName;


    //Lazy loading vs eager loading-->
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
//
//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Employee dep;//


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }

    public Long getId() {
        return id;
    }

}
