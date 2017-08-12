package edu.mum.cs.projects.carpooling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByName(String username);

	Users findByStudentId(String studentId);

	Users findById(int userId);

}
