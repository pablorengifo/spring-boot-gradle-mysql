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
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private Integer enabled;
}
