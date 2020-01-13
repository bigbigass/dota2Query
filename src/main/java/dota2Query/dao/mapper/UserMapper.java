package dota2Query.dao.mapper;

import static dota2Query.util.common.Dota2Constants.*;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import dota2Query.domain.User;
public interface UserMapper {
	@Select("SELECT * FROM " + USERTABLE +"WHERE dota2_acc_id=#{dota2_acc_id}")
	User selectById(Long dota2_acc_id);
	
	@Select("SELECT * FROM "+USERTABLE+" WHERE dota2_acc_id IN (SELECT acc_id FROM "+
			USER_MAT_TABLE+" WHERE mat_id=#{mat_id})")
	List<User> selectUserByMatId(Long mat_id);
}
