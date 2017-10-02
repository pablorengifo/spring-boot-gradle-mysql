package com.javasampleapproach.security.repository;

import com.javasampleapproach.security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by prengifo on 10/1/17.
 */
@RepositoryRestResource(collectionResourceRel = "role", path = "role")
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
