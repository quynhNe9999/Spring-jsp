package com.oneempower.auth.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oneempower.auth.model.User;
import com.oneempower.auth.repository.RoleRepository;
import com.oneempower.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		User updateUser = userRepository.findById(user.getId()).orElse(null);
		user.setUsername(user.getUsername());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
//	    updateUser.setPasswordConfirm(user.getPasswordConfirm());
//	    updateUser.setRoles(user.getRoles());
		return userRepository.save(user);
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public Page<User> searchSinhVien(Optional<String> keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.FindAllByUserNameorEmailorAddress(keyword, pageable);
	}

}