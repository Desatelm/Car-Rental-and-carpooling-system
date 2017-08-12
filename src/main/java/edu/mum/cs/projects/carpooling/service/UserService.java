package edu.mum.cs.projects.carpooling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.projects.carpooling.domain.entity.CustomUserDetails;
import edu.mum.cs.projects.carpooling.domain.entity.Role;
import edu.mum.cs.projects.carpooling.domain.entity.Users;
import edu.mum.cs.projects.carpooling.repository.UsersRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserService userService;

	public void createUser(Users user) {
		usersRepository.save(user);
	}

	public Users getUserByID(int userId) {
		return usersRepository.findById(userId);
	}

	public Users getUserByUserName(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByName(username);
		if (!optionalUsers.isPresent()) {
			return null;
		}
		return optionalUsers.map(Users::new).get();
	}

	public Users getUser(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByName(username);

		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

	@Transactional
	public void creatUsers() {
		
	}
		
}
