package dota2Query.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;

import dota2Query.dao.provider.UserDynaSqlProvider;
import dota2Query.domain.User;

import static dota2Query.util.common.Dota2Constants.*;
public interface UserDao {
	//根据账户名与密码查询用户(check)
	@Select("select * from " + USERTABLE +" where account = #{account} and password = #{password}")
	@Results(id="userMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="win",property="win"),
			@Result(column="dota2_acc_id",property="dota2_acc_id"),
			@Result(column="account",property="account"),
			@Result(column="password",property="password"),
			@Result(column="NAME",property="name"),
			@Result(column="IMG",property="img"),
			@Result(column="phone",property="phone"),
			@Result(column="qq_num",property="qq_num"),
			@Result(column="email",property="email"),
			@Result(column="wxid",property="wxid"),
			@Result(column="isSys",property="isSys"),
			@Result(column="loby7",property="loby7"),
			@Result(column="loby7win",property="loby7win"),
			@Result(column="steam_code",property="steam_code"),
			@Result(column="steam_name",property="steam_name"),
			@Result(column="dota2_acc_id",property="matchs",many=@Many(
					select="dota2Query.dao.mapper.MatchMapper.selectMatchByUserId",
					fetchType=FetchType.LAZY))
	})
	User selectByAccountAndPassword(@Param("account") String account,
			@Param("password") String password);
	//根据手机号与密码查询用户(check)
	@Select("select * from " + USERTABLE +" where phone = #{phone} and password = #{password}")
	@ResultMap("userMap")
	User selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);
	//根据email与密码查询用户(check)
	@Select("select * from " + USERTABLE +" where email = #{email} and password = #{password}")
	@ResultMap("userMap")
	User selectByEmailAndPassword(@Param("email")String email, @Param("password") String password);
	//根据id查询用户(check)
	@Select("select * from " + USERTABLE +" where dota2_acc_id = #{dota2_acc_id}")
	@ResultMap("userMap")
	User selectUserById(@Param("dota2_acc_id")long id);
	//根据steamid查询用户(check)
		@Select("select * from " + USERTABLE +" where  steam_code  = #{steam32}")
		@ResultMap("userMap")
		User selectUserBySteamId(@Param("steam32")String id);
	//根据账号查询用户
	@Select("select * from " + USERTABLE +" where account = #{account}")
	@ResultMap("userMap")
	User selectUserByAccount(String account);
	//查询所有已经同步的用户
	@Select("select * from "+USERTABLE+" where isSys=2")
	@ResultMap("userMap")
	List<User> selectIsSysUser();
	//根据dotaid删除用户(check)
	@Delete(" delete from " + USERTABLE+" where dota2_acc_id= #{id}")
	void deleteUserByAcc_Id(Long id);
	//根据id删除用户(check)
		@Delete(" delete from " + USERTABLE+" where id= #{id}")
		void deleteUserById(int id);
	//根据账户删除用户
	@Delete(" delete from " + USERTABLE+" where account= #{account}")
	void deleteUserByAccount(String account);
	//动态修改用户(check)
	@UpdateProvider(type=UserDynaSqlProvider.class, method="updateUser")
	void update(User user);
	//动态查询(check)
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWithParam")
	@ResultMap("userMap")
	List<User> selectByPage(Map<String, Object> params);
	//根据参数查询用户总数(check)
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	//动态插入用户(check)
	@InsertProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);
}
