package com.tangj.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tangj.springboot.entity.UserDTO;
import com.tangj.springboot.model.UserModel;
import com.tangj.springboot.property.NeoProperties;
import com.tangj.springboot.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user")
@Api("测试user业务")
public class UserController {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(UserController.class);// 日志

	@Autowired
	private NeoProperties neoProperties;// 使用自定义配置的属性

	@Autowired
	private UserService userService;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/getUser")
	@Cacheable(value = "user-key") // 自动根据方法生成缓存
	public UserDTO getUser() {
		UserDTO user = userService.findByUserName("aa");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}

	@RequestMapping("/getUserSession")
	String getUserSession(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}

	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("/getUserList")
	@ApiOperation(value = "分页查询用户,使用jpa查询")
	public Object getUserList() {
		// 页数需从零开始
		int page = 0, size = 10;
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		Page<UserDTO> userPage = userService.findByUserName("bb2", pageable);
		return userPage.getContent();
	}

	/**
	 * 分页查询2
	 * @return
	 */
	@RequestMapping("/getUserList2")
	@ApiOperation(value = "分页查询用户,使用mybatis查询")
	public Object getUserList2() {
		List<UserDTO> userList = userService.findByUserName2("bb2");
		return userList;
	}

	/**
	 * 测试自定义属性
	 * @return
	 */
	@RequestMapping("/testNeoProperties")
	public String index() {
		return neoProperties.getTitle();
	}

	/**
	 * 测试返回 Map列表
	 * @return
	 */
	@RequestMapping("/testMapList")
	@ApiOperation(value = "测试返回List<Map<String, Object>>")
	public Object testMapList() {
		List<Map<String, Object>> userList = userService.testGetMapList();
		return userList;
	}

	/**
	 * 测试返回 Map列表
	 * @return
	 */
	@RequestMapping("/testMapList2")
	@ApiOperation(value = "测试返回List<Map<String, Object>>")
	public Object testMapList2() {
		List<Map<String, Object>> userList = userService.testGetMapList2();
		return userList;
	}

	/**
	 * 测试返回 Map列表
	 * @return
	 */
	@RequestMapping("/testMapList3")
	@ApiOperation(value = "测试返回List<Map<String, Object>>")
	public Object testMapList3() {
		List<Map<String, Object>> userList = userService.testGetMapList3();
		return userList;
	}

	/**
	 * 测试返回自定义类型数据
	 * @return
	 */
	@RequestMapping("/testGetModelList")
	@ApiOperation(value = "测试返回自定义类型数据")
	public Object testGetModelList() {
		List<UserModel> userList = userService.testGetModelList();
		return userList;
	}

	/**
	 * 测试 自定义查询返回所有字段
	 * @return
	 */
	@RequestMapping("/testGetAllField")
	@ApiOperation(value = "测试 自定义查询返回所有字段")
	public Object testGetAllField() {
		List<UserDTO> userList = userService.testGetAllField();
		return userList;
	}

	/**
	 * 测试 自定义查询返回部分字段
	 * @return
	 */
	@RequestMapping("/testGetSomeField")
	@ApiOperation(value = "测试 自定义查询返回部分字段")
	public Object testGetSomeField() {
		List<UserDTO> userList = userService.testGetSomeField();
		return userList;
	}

	/**
	 * 测试 使用原生sql
	 * @return
	 */
	@RequestMapping("/testNativeQuery")
	@ApiOperation(value = "测试 使用原生sql")
	public Object testNativeQuery() {
		List<UserDTO> userList = userService.testNativeQuery();
		return userList;
	}

	/**
	 * 测试 使用原生sql2
	 * @return
	 */
	@RequestMapping("/testNativeQuery2")
	@ApiOperation(value = "测试 使用原生sql")
	public Object testNativeQuery2() {
		List<UserDTO> userList = userService.testNativeQuery2();
		return userList;
	}
	/**
	 * 测试 使用原生sql3
	 * @return
	 */
	@RequestMapping("/testNativeQuery3")
	@ApiOperation(value = "测试 使用原生sql")
	public Object testNativeQuery3() {
		List<Object> userList = userService.testNativeQuery3();
		return userList;
	}
	/**
	 * 测试 使用原生sql3
	 * @return
	 */
	@RequestMapping("/testNativeQuery4")
	@ApiOperation(value = "测试 使用原生sql")
	public Object testNativeQuery4() {
		List<UserModel> userList = userService.testNativeQuery4();
		return userList;
	}
	// /**
	// * 测试 使用原生sql
	// * @return
	// */
	// @RequestMapping("/testNativeQuery")
	// @ApiOperation(value = "测试 使用原生sql")
	// public Object testNativeQuery() {
	// List<UserDTO> userList = userService.testNativeQuery();
	// return userList;
	// }

}
