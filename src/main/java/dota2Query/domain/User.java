package dota2Query.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = { "handler" })
public class User implements Serializable {
	public User() {}
	
	public User(String account, String password,long dota2_acc_id, String name, String img, String phone,
			String qq_num, String email, String wxid, int isSys, String steam_code, String steam_name,
			List<Match> matchs) {
		super();
		this.account = account;
		this.password = password;
		this.dota2_acc_id = dota2_acc_id;
		this.name = name;
		this.img = img;
		this.phone = phone;
		this.qq_num = qq_num;
		this.email = email;
		this.wxid = wxid;
		this.isSys = isSys;
		this.steam_code = steam_code;
		this.steam_name = steam_name;
		this.matchs = matchs;
	}
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	private int matNum;
	private int win;
	private String account;// 账户
	private String password;// 密码
	private long dota2_acc_id;// dota账户id
	private String name;// 昵称
	private String img;// 头像
	private String phone;// 手机
	private String qq_num;// qq号
	private String email;// 邮箱
	private String wxid;// 微信号
	private int isSys;// 是否同步
	private String steam_code;// steamid
	private String steam_name;// steam昵称
	private List<Match> matchs;// 用户比赛列表
	private int loby7;
	private int loby7win;
	
	private float dataOf20;
	private float dataOf20Lobby7;

	
	public float getDataOf20() {
		return dataOf20;
	}

	public void setDataOf20(float dataOf20) {
		this.dataOf20 = dataOf20;
	}

	public float getDataOf20Lobby7() {
		return dataOf20Lobby7;
	}

	public void setDataOf20Lobby7(float dataOf20Lobby7) {
		this.dataOf20Lobby7 = dataOf20Lobby7;
	}

	public int getLoby7() {
		return loby7;
	}

	public void setLoby7(int loby7) {
		this.loby7 = loby7;
	}

	public int getLoby7win() {
		return loby7win;
	}

	public void setLoby7win(int loby7win) {
		this.loby7win = loby7win;
	}

	public int getMatNum() {
		return matNum;
	}

	public void setMatNum(int matNum) {
		this.matNum = matNum;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passowrd) {
		this.password = passowrd;
	}

	public long getDota2_acc_id() {
		return dota2_acc_id;
	}

	public void setDota2_acc_id(long dota2_acc_id) {
		this.dota2_acc_id = dota2_acc_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}



	public String getSteam_code() {
		return steam_code;
	}

	public void setSteam_code(String steam_code) {
		this.steam_code = steam_code;
	}

	public String getSteam_name() {
		return steam_name;
	}

	public void setSteam_name(String steam_name) {
		this.steam_name = steam_name;
	}

	public List<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", dota2_acc_id=" + dota2_acc_id + ", name="
				+ name + ", img=" + img + ", phone=" + phone + ", qq_num=" + qq_num + ", email=" + email + ", wxid="
				+ wxid + ", isSys=" + isSys + ", steam_code=" + steam_code + ", steam_name=" + steam_name ;
	}

	public int getIsSys() {
		return isSys;
	}

	public void setIsSys(int isSys) {
		this.isSys = isSys;
	}
}
