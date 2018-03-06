package com.tangj.springboot.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义一些配置
 * @author tangj
 *
 */
@Component
@ConfigurationProperties(prefix = "com.neo") // ,使用此方法,设置前缀，属性上不需要添加注解
public class NeoProperties {

	// @Value("${com.neo.title}")
	private String title;

	// @Value("${com.neo.description}")
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}