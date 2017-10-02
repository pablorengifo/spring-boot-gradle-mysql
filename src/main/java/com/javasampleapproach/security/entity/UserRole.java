package com.javasampleapproach.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by prengifo on 10/1/17.
 */
@Entity
@Table(name="user_roles")
@Getter
@Setter
public class UserRole {
    @Id
    @Column(name="user_role_id")
    private Integer id;

    @Column(name="username")
    private String userName;

    @Column(name="role")
    private String role;
}
