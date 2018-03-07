package com.tangj.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tangj.springboot.entity.UserDTO;

@Mapper
public interface UserMapper {

	@Select("select count(1) from BC_QR_Scene")
	int findCount();

	@Select("select ID,Name,SceneCode from BC_QR_Scene where ID = #{id}")
	UserDTO findById(@Param("id") int id);

	Long save(@Param("user") UserDTO user);

	List<UserDTO> findByUserName(@Param("userName") String userName);
}
