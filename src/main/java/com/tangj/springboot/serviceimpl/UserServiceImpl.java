package com.tangj.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tangj.springboot.dao.jpa.UserRepository;
import com.tangj.springboot.dao.mapper.UserMapper;
import com.tangj.springboot.entity.UserDTO;
import com.tangj.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDTO findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserDTO findByUserNameLike(String userName) {
		return userRepository.findByUserNameLike(userName);
	}

	@Override
	public UserDTO findByUserNameOrEmail(String userName, String email) {
		return userRepository.findByUserNameOrEmail(userName, email);
	}

	@Override
	public Page<UserDTO> findByUserName(String userName, Pageable pageable) {
		return userRepository.findByUserName(userName, pageable);
	}

	@Override
	public List<UserDTO> findByUserName(String userName, Sort sort) {
		return userRepository.findByUserName(userName, sort);
	}

	@Transactional
	@Override
	public Long save(UserDTO user) {
		return userMapper.save(user);
	}

}
