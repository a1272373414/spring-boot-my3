package com.tangj.springboot.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tangj.springboot.dao.jpa.UserRepository;
import com.tangj.springboot.dao.mybatis.UserMapper;
import com.tangj.springboot.entity.UserDTO;
import com.tangj.springboot.model.UserModel;
import com.tangj.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public <S extends UserDTO> long count(Example<S> example) {
		return userRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends UserDTO> entities) {
		userRepository.delete(entities);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void delete(UserDTO entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<UserDTO> entities) {
		userRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends UserDTO> boolean exists(Example<S> example) {
		return userRepository.exists(example);
	}

	@Override
	public boolean exists(Long id) {
		return userRepository.exists(id);
	}

	@Override
	public List<UserDTO> findAll() {
		return userRepository.findAll();
	}

	@Override
	public <S extends UserDTO> List<S> findAll(Example<S> example) {
		return userRepository.findAll(example);
	}

	@Override
	public <S extends UserDTO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return userRepository.findAll(example, pageable);
	}

	@Override
	public <S extends UserDTO> List<S> findAll(Example<S> example, Sort sort) {
		return userRepository.findAll(example, sort);
	}

	@Override
	public List<UserDTO> findAll(Iterable<Long> ids) {
		return userRepository.findAll(ids);
	}

	@Override
	public Page<UserDTO> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<UserDTO> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public <S extends UserDTO> S findOne(Example<S> example) {
		return userRepository.findOne(example);
	}

	@Override
	public UserDTO findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void flush() {
		userRepository.flush();

	}

	@Override
	public UserDTO getOne(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public <S extends UserDTO> List<S> save(Iterable<S> entities) {
		return userRepository.save(entities);
	}

	@Override
	public <S extends UserDTO> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public <S extends UserDTO> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	/************************ 以下为自定义的方法 ****************************************/

	@Override
	public UserDTO findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public Page<UserDTO> findByUserName(String userName, Pageable pageable) {
		return userRepository.findByUserName(userName, pageable);
	}

	@Override
	public List<UserDTO> findByUserName(String userName, Sort sort) {
		return userRepository.findByUserName(userName, sort);
	}

	@Override
	public List<UserDTO> findByUserName2(String userName) {
		return userMapper.findByUserName(userName);
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
	public List<Map<String, Object>> testGetMapList() {
		return userRepository.testGetMapList();
	}

	@Override
	public List<Map<String, Object>> testGetMapList2() {
		return userRepository.testGetMapList2();
	}

	@Override
	public List<Map<String, Object>> testGetMapList3() {
		return userRepository.testGetMapList3();
	}

	@Override
	public List<UserModel> testGetModelList() {
		return userRepository.testGetModelList();
	}

	@Override
	public List<UserDTO> testGetAllField() {
		return userRepository.testGetAllField();
	}

	@Override
	public List<UserDTO> testGetSomeField() {
		return userRepository.testGetSomeField();
	}

	@Override
	public List<UserDTO> testNativeQuery() {
		return userRepository.testNativeQuery();
	}

	@Override
	public List<UserDTO> testNativeQuery2() {
		return userRepository.testNativeQuery2();
	}

	@Override
	public List<Object> testNativeQuery3() {
		return userRepository.testNativeQuery3();
	}

	@Override
	public List<UserModel> testNativeQuery4() {
		return userRepository.testNativeQuery4();
	}

}
