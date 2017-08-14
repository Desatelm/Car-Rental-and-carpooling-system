package edu.mum.cs.projects.carpooling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;

public interface MessageBoxRepository extends JpaRepository<MessageBox, Integer> {

}
