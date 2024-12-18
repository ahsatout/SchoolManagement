package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;
import com.hyh.schoolmanagement.annotation.Table;

@Table(name = "user")
public class User implements Cloneable {

    @Column(name = "id", type = "BIGINT", primaryKey = true)
    private Long id;

    @Column(name = "username", type = "VARCHAR(255)")
    private String username;

    @Column(name = "password", type = "VARCHAR(255)")
    private String password;

    @Column(name = "role", type = "VARCHAR(255)")
    private Role role;


    public User(Long id, String username, String password, Role role) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, Role role) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User student = (User) super.clone();
        return student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "username = " + username + ", password = " + password + ", role = " + role;
    }

}

