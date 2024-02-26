package com.oneempower.auth.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.oneempower.auth.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);

	Page<User> findAll(Pageable pageable);

	User insert(User user);

	boolean delete(long id);

	User update(User user);

	User findById(long id);

	Page<User> searchSinhVien(Optional<String> keyword, Pageable pageable);
	
}
