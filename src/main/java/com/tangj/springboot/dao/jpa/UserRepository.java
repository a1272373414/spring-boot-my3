package com.tangj.springboot.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tangj.springboot.entity.UserDTO;

public interface UserRepository extends JpaRepository<UserDTO, Long> {

	UserDTO findByUserName(String userName);

	UserDTO findByUserNameLike(String userName);

	UserDTO findByUserNameOrEmail(String userName, String email);

	Page<UserDTO> findByUserName(String userName, Pageable pageable);

	List<UserDTO> findByUserName(String userName, Sort sort);
	
	
	/**
	 * 1.自定义的SQL,在SQL的查询方法上面使用@Query注解
	 * 2.如涉及到删除和修改在需要加上@Modifying
	 * 3.timeout 查询超时
	 * 
	 * 此处的表名需和实体类的名称一致
	 */
	@Transactional(timeout = 10)	
	@Modifying
	@Query("delete from UserDTO where id = ?1")
	void deleteByUserId(Long id);

}