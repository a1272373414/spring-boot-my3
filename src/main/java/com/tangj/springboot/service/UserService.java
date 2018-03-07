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

	/**
	 * 使用jpa查询
	 * @param userName
	 * @param sort
	 * @return
	 */
	List<UserDTO> findByUserName(String userName, Sort sort);
	
	/**
	 * 使用mybatis查询
	 * @param userName
	 * @return
	 */
	List<UserDTO> findByUserName2(String userName);
	
	Long save(UserDTO user);
	
}
