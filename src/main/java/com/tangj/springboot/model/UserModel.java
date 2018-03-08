package com.tangj.springboot.model;

/**
 * 自定义model,用于传输数据
 *
 */
public class UserModel {

	private Long id;

	private String userName;

	private String passWord;

	private String remark;

	public UserModel() {
		super();
	}

	public UserModel(Long id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	public UserModel(Long id, String userName, String passWord, String remark) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
