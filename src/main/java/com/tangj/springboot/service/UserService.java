package com.tangj.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tangj.springboot.entity.UserDTO;

public interface UserService {
	UserDTO findByUserName(String userName);

	UserDTO findByUserNameLike(String userName);

	UserDTO findByUserNameOrEmail(String userName, String email);

	Page<UserDTO> findByUserName(String userName, Pageable pageable);

	List<UserDTO> findByUserName(String userName, Sort sort);
	
	Long save(UserDTO user);
	
}
