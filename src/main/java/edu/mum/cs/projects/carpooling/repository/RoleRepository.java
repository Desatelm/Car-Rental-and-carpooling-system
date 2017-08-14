package edu.mum.cs.projects.carpooling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByRoleType(String role);
}
