package com.tangj.springboot.common.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 定义service的公共方法
 * @NoRepositoryBean 该注解表示 spring 容器不会创建该对象
 */
@NoRepositoryBean
public interface BaseService<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
