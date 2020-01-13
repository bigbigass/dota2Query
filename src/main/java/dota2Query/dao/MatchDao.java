package dota2Query.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
import org.apache.ibatis.annotations.One;

import dota2Query.dao.provider.MatchDynaSqlProvider;
import dota2Query.domain.DataOf20;
import dota2Query.domain.Match;
import dota2Query.domain.User;

import static dota2Query.util.common.Dota2Constants.*;
public interface MatchDao {
	//根据id返回比赛(check)
	@Select("SELECT * FROM " + MATCHTABLE+" WHERE mat_id=#{id}")
	@Results(id="matchMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="mat_id",property="mat_id"),
			@Result(column="seq",property="seq"),
			@Result(column="start",property="start"),
			@Result(column="duration",property="duration"),
			@Result(column="radiant_win",property="radiant_win"),
			@Result(column="cluster",property="cluster"),
			@Result(column="first_blood_time",property="first_blood_time"),
			@Result(column="lobby_type",property="lobby_type"),
			@Result(column="leagueid",property="leagueid"),
			@Result(column="game_mode",property="game_mode"),
			@Result(column="radiant_score",property="radiant_score"),
			@Result(column="dire_score",property="dire_score"),
			@Result(column="mat_id",property="users",many=@Many(
					select="dota2Query.dao.mapper.UserMapper.selectUserByMatId",
					fetchType=FetchType.LAZY)),
			@Result(column="mat_id",property="user_mats",many=@Many(
					select="dota2Query.dao.mapper.User_matMapper.selectUser_matsByMat_id",fetchType=FetchType.LAZY))
	})
	Match selectMatchById(Long id);
	
	//动态添加比赛(check)
	@InsertProvider(type=MatchDynaSqlProvider.class, method="save")
	void saveMatch(Match match);
	/*/根据acc_id查询比赛(check)
	@Select("SELECT * FROM " + MATCHTABLE + " WHERE acc_id=#{acc_id}")
	@ResultMap("matchMap")
	List<Match> selectMatchOfId(Long mat_id);*/
	
	//根据用户id返回在数据库中的比赛数量(check)
	@Select("SELECT count(*) FROM " + USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id}")
	Integer selectCountOfUserId(Long dota2_acc_id);

	//分页查询(check)
	@SelectProvider(type=MatchDynaSqlProvider.class,method="selectMatchByParams")
	@ResultMap("matchMap")
	List<Match> selectMatchByParams(Map<String, Object> params);
	
	@Select("SELECT mat_id FROM "+MATCHTABLE+" WHERE mat_id IN (SELECT mat_id FROM "+
			USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id}) order by start desc limit 1")
	Long selectNewMatch(Long dota2_acc_id);
	
}
