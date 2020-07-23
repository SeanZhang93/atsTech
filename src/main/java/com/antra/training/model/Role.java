//package com.antra.training.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "role")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "allowed_resource")
//    private String allowedResource;
//
//    @Column(name = "allowed_create")
//    private String allowedCreate;
//
//    @Column(name = "allowed_read")
//    private String allowedRead;
//
//    @Column(name = "allowed_update")
//    private String allowedUpdate;
//
//    @Column(name = "allowed_delete")
//    private String allowedDelete;
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "roles") //roles 要对照users里的
//    private Set users;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAllowedResource() {
//        return allowedResource;
//    }
//
//    public void setAllowedResource(String allowedResource) {
//        this.allowedResource = allowedResource;
//    }
//
//    public String getAllowedCreate() {
//        return allowedCreate;
//    }
//
//    public void setAllowedCreate(String allowedCreate) {
//        this.allowedCreate = allowedCreate;
//    }
//
//    public String getAllowedRead() {
//        return allowedRead;
//    }
//
//    public void setAllowedRead(String allowedRead) {
//        this.allowedRead = allowedRead;
//    }
//
//    public String getAllowedUpdate() {
//        return allowedUpdate;
//    }
//
//    public void setAllowedUpdate(String allowedUpdate) {
//        this.allowedUpdate = allowedUpdate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Role role = (Role) o;
//        return Objects.equals(id, role.id) &&
//                Objects.equals(name, role.name) &&
//                Objects.equals(allowedResource, role.allowedResource) &&
//                Objects.equals(allowedCreate, role.allowedCreate) &&
//                Objects.equals(allowedRead, role.allowedRead) &&
//                Objects.equals(allowedUpdate, role.allowedUpdate) &&
//                Objects.equals(allowedDelete, role.allowedDelete);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, allowedResource, allowedCreate, allowedRead, allowedUpdate, allowedDelete);
//    }
//
//    public String getAllowedDelete() {
//        return allowedDelete;
//    }
//
//    public void setAllowedDelete(String allowedDelete) {
//        this.allowedDelete = allowedDelete;
//    }
//
//    public Set getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set users) {
//        this.users = users;
//    }
//
//}
