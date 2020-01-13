package dota2Query.domain;

import java.io.Serializable;

import com.mchange.v2.async.StrandedTaskReporting;

public class DataOfLogin implements Serializable{
	public DataOfLogin() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String state="ok";
	public String code= "0";
	public String token= "";
	public DataOfLogin(String state, String code, String token) {
		super();
		this.state = state;
		this.code = code;
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * code意义：
	 * 		0：成功
	 * 		1 ：账号或密码错误
	 * 		2：验证码错误
	 * 		3:账号已经存在
	 */

	public String getState() {
		return state;
	}

	public void setState(String data) {
		this.state = data;
	}
}
