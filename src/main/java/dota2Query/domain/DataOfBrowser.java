package dota2Query.domain;

public class DataOfBrowser {
	private String account; 
	private String password;
	private String catcharCode;
	private String token;
	private Long acc_id;
	private int pageNum;
	public DataOfBrowser() {}
	
	public DataOfBrowser(String account, String password, String catcharCode, String token) {
		super();
		this.account = account;
		this.password = password;
		this.catcharCode = catcharCode;
		this.token=token;
	}

	
	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCatcharCode() {
		return catcharCode;
	}
	public void setCatcharCode(String catcharCode) {
		this.catcharCode = catcharCode;
	}

	@Override
	public String toString() {
		return "DataOfBrowser [account=" + account + ", password=" + password + ", catcharCode=" + catcharCode
				+ ", token=" + token + ", acc_id=" + acc_id + ", pageNum=" + pageNum + "]";
	}
}
