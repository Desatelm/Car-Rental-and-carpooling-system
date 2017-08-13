package edu.mum.cs.projects.carpooling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String username);

	User findById(int userId);
	User findByEmailAddress(String emailAddress);

}
