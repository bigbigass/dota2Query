package dota2Query.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import dota2Query.domain.User;

import static dota2Query.util.common.Dota2Constants.*;
public class UserDynaSqlProvider {
	//分页动态查询
	public String selectWithParam(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user")!=null) {
					User user = (User) params.get("user");
					if (user.getName() != null && user.getName().equals("")) {
							WHERE(" name LIKE CONCAT('%',#{user.name},'%')");
					}
				}
			}
		}.toString();
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
		}
		return sql;
	}
	//动态查询总数量
	public String count(final Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if (params.get("user") != null) {
					User user = (User) params.get("user");
					if (user.getName() != null && !user.getName().equals("")) {
						WHERE(" name LIKE CONCAT('%',#{user.name},'%')");
					}
				}
			}
		}.toString();
	}
	//动态插入
	public String insertUser(final User user) {
		return new SQL() {
			{
				INSERT_INTO(USERTABLE);
				if(user.getDota2_acc_id()!=0) {
					VALUES("dota2_acc_id", "#{dota2_acc_id}");
				}
				if(user.getAccount() != null && !user.getAccount().equals("")) {
					VALUES("account", "#{account}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (user.getImg()!=null) {
					VALUES(" IMG","#{img} ");
				}
				if(user.getName() != null && !user.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if(user.getPhone() != null && !user.getPhone().equals("")) {
					VALUES("phone", "#{phone}");
				}
				if(user.getQq_num() != null && !user.getQq_num().equals("")) {
					VALUES("qq_num", "#{qq_num}");
				}
				if(user.getEmail() != null && !user.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if(user.getWxid() != null && !user.getWxid().equals("")) {
					VALUES("wxid", "#{wxid}");
				}
				VALUES("isSys", "#{isSys}");
				if(user.getSteam_code()!=null&&!user.getSteam_code().equals("")) {
					VALUES("steam_code", "#{steam_code}");
				}
				if (user.getSteam_name()!=null&&!user.getSteam_name().equals("")) {
					VALUES("steam_name", "#{steam_name}");
				}
			}
		}.toString();
	}
	//动态更新
	public String updateUser(final User user) {
		return new SQL() {
			{
				UPDATE(USERTABLE);
				if (user.getAccount()!=null) {
					SET(" account=#{account} ");
				}
				if (user.getPassword()!=null) {
					SET(" password=#{password} ");
				}
				if (user.getName()!=null) {
					SET(" NAME=#{name} ");
				}
				if (user.getImg()!=null) {
					SET(" IMG=#{img} ");
				}
				if (user.getPhone()!=null) {
					SET(" phone=#{phone} ");
				}
				if (user.getQq_num()!=null) {
					SET(" qq_num=#{qq_num} ");
				}
				if (user.getEmail()!=null) {
					SET(" email=#{email} ");
				}
				if (user.getWxid()!=null) {
					SET(" wxid=#{wxid} ");
				}
				if (user.getIsSys()!=0) {
					SET(" isSys=#{isSys} ");
				}
				if (user.getDota2_acc_id()!=0) {
					SET("dota2_acc_id=#{dota2_acc_id}");
				}
				if (user.getSteam_code()!=null) {
					SET(" steam_code =#{steam_code} ");
				}
				if (user.getSteam_name()!=null) {
					SET(" steam_name=#{steam_name} ");
				}

					SET("IMG=#{img}");
				
				SET("win = #{win}");
				SET("loby7win = #{loby7win}");
				SET("loby7 = #{loby7}");
				WHERE(" id=#{id}");
			}
		}.toString();
	}
}
