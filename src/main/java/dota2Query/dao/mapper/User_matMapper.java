package dota2Query.dao.mapper;
import static dota2Query.util.common.Dota2Constants.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dota2Query.domain.User_mat;
public interface User_matMapper {
	@Select("SELECT * FROM " + USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id} AND mat_id=#{mat_id}")
	User_mat selectUser_matByAccIdAndMatId(
			@Param("dota2_acc_id")Long acc_id,@Param("mat_id")Long mat_id);
	
	@Select("SELECT * FROM " + USER_MAT_TABLE+" WHERE mat_id=#{mat_id}")
	List<User_mat> selectUser_matsByMat_id(Long mat_id);
	
	@Select("SELECT solt FROM"+USER_MAT_TABLE+" WHERE  acc_id=#{acc_id} AND mat_id=#{mat_id}")
	Integer selectUserSolt(@Param("acc_id")Long acc_id,@Param("mat_id")Long mat_id);
}
