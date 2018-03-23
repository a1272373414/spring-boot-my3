package com.tangj.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tangj.springboot.common.service.BaseService;
import com.tangj.springboot.entity.UserDTO;
import com.tangj.springboot.model.UserModel;

public interface UserService extends BaseService<UserDTO, Long> {

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

	/**
	 * 测试返回Map列表
	 * @return
	 */
	List<Map<String, Object>> testGetMapList();

	/**
	 * 测试返回Map列表2
	 * @return
	 */
	List<Map<String, Object>> testGetMapList2();

	/**
	 * 测试返回Map列表3
	 * @return
	 */
	List<Map<String, Object>> testGetMapList3();

	/**
	 * 测试返回自定义类型数据
	 * @return
	 */
	List<UserModel> testGetModelList();

	/**
	 * 测试 自定义查询返回所有字段
	 * @return
	 */
	List<UserDTO> testGetAllField();

	/**
	 * 测试 自定义查询返回部分字段
	 * @return
	 */
	List<UserDTO> testGetSomeField();

	/**
	 * 测试 使用原生sql
	 * @return
	 */
	List<UserDTO> testNativeQuery();

	/**
	 * 测试 使用原生sql2
	 * @return
	 */
	List<UserDTO> testNativeQuery2();

	/**
	 * 测试 使用原生sql3
	 * @return
	 */
	List<Object> testNativeQuery3();

	/**
	 * 测试 使用原生sql4
	 * @return
	 */
	List<UserModel> testNativeQuery4();

	// Long save(UserDTO user);

}
