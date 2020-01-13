package dota2Query.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import dota2Query.domain.DataOf20;
import dota2Query.domain.Match;
import dota2Query.domain.User_mat;
import dota2Query.dao.provider.User_matDynaSqlProvider;

import static dota2Query.util.common.Dota2Constants.*;

import java.util.List;
import java.util.Map;

public interface User_matDao {
	//根据acc_id和mat_id确认具体比赛信息
	@Select("SELECT * FROM " + USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id} AND mat_id=#{mat_id}")
	@Results(id="user_matMap",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="acc_id",property="acc_id"),
			@Result(column="mat_id",property="mat_id"),
			@Result(column="solt",property="solt"),
			@Result(column="hero_id",property="hero_id"),
			@Result(column="item0",property="item0"),
			@Result(column="item1",property="item1"),
			@Result(column="item2",property="item2"),
			@Result(column="item3",property="item3"),
			@Result(column="item4",property="item4"),
			@Result(column="item5",property="item5"),
			@Result(column="bac0",property="bac0"),
			@Result(column="bac1",property="bac1"),
			@Result(column="bac2",property="bac2"),
			@Result(column="bac3",property="bac3"),
			@Result(column="kill_num",property="kill_num"),
			@Result(column="deaths",property="deaths"),
			@Result(column="assists",property="assists"),
			@Result(column="leaver_status",property="leaver_status"),
			@Result(column="last_hit",property="last_hit"),
			@Result(column="denis",property="denis"),
			@Result(column="gpm",property="gpm"),
			@Result(column="xpm",property="xpm"),
			@Result(column="level",property="level"),
			@Result(column="hero_damage",property="hero_damage"),
			@Result(column="tower_damage",property="tower_damage"),
			@Result(column="hero_healing",property="hero_healing"),
			@Result(column="gold_spent",property="gold_spent"),
			@Result(column="ability_code1",property="ability_code1"),
			@Result(column="ability_time1",property="ability_time1"),
			@Result(column="ability_level1",property="ability_level1"),
			@Result(column="ability_code2",property="ability_code2"),
			@Result(column="ability_time2",property="ability_time2"),
			@Result(column="ability_level2",property="ability_level2"),
			@Result(column="ability_code3",property="ability_code3"),
			@Result(column="ability_time3",property="ability_time3"),
			@Result(column="ability_level3",property="ability_level3"),
			@Result(column="ability_code4",property="ability_code4"),
			@Result(column="ability_time4",property="ability_time4"),
			@Result(column="ability_level4",property="ability_level4"),
			@Result(column="ability_code5",property="ability_code5"),
			@Result(column="ability_time5",property="ability_time5"),
			@Result(column="ability_level5",property="ability_level5"),
			@Result(column="ability_code6",property="ability_code6"),
			@Result(column="ability_time6",property="ability_time6"),
			@Result(column="ability_level6",property="ability_level6"),
			@Result(column="ability_code7",property="ability_code7"),
			@Result(column="ability_time7",property="ability_time7"),
			@Result(column="ability_level7",property="ability_level7"),
			@Result(column="ability_code8",property="ability_code8"),
			@Result(column="ability_time8",property="ability_time8"),
			@Result(column="ability_level8",property="ability_level8"),
			@Result(column="ability_code9",property="ability_code9"),
			@Result(column="ability_time9",property="ability_time9"),
			@Result(column="ability_level9",property="ability_level9"),
			@Result(column="ability_code10",property="ability_code10"),
			@Result(column="ability_time10",property="ability_time10"),
			@Result(column="ability_level10",property="ability_level10"),
			@Result(column="ability_code11",property="ability_code11"),
			@Result(column="ability_time11",property="ability_time11"),
			@Result(column="ability_level11",property="ability_level11"),
			@Result(column="ability_code12",property="ability_code12"),
			@Result(column="ability_time12",property="ability_time12"),
			@Result(column="ability_level12",property="ability_level12"),
			@Result(column="ability_code13",property="ability_code13"),
			@Result(column="ability_time13",property="ability_time13"),
			@Result(column="ability_level13",property="ability_level13"),
			@Result(column="ability_code14",property="ability_code14"),
			@Result(column="ability_time14",property="ability_time14"),
			@Result(column="ability_level14",property="ability_level14"),
			@Result(column="ability_code15",property="ability_code15"),
			@Result(column="ability_time15",property="ability_time15"),
			@Result(column="ability_level15",property="ability_level15"),
			@Result(column="ability_code116",property="ability_code16"),
			@Result(column="ability_time16",property="ability_time16"),
			@Result(column="ability_level16",property="ability_level16"),
			@Result(column="ability_code17",property="ability_code17"),
			@Result(column="ability_time17",property="ability_time17"),
			@Result(column="ability_level17",property="ability_level17"),
			@Result(column="ability_code18",property="ability_code18"),
			@Result(column="ability_time18",property="ability_time18"),
			@Result(column="ability_level18",property="ability_level18"),
			@Result(column="ability_code19",property="ability_code19"),
			@Result(column="ability_time19",property="ability_time19"),
			@Result(column="ability_level19",property="ability_level19"),
			@Result(column="ability_code20",property="ability_code20"),
			@Result(column="ability_time20",property="ability_time20"),
			@Result(column="ability_level20",property="ability_level20"),
			@Result(column="ability_code21",property="ability_code21"),
			@Result(column="ability_time21",property="ability_time21"),
			@Result(column="ability_level21",property="ability_level21"),
			@Result(column="ability_code22",property="ability_code22"),
			@Result(column="ability_time22",property="ability_time22"),
			@Result(column="ability_level22",property="ability_level22"),
			@Result(column="ability_code23",property="ability_code23"),
			@Result(column="ability_time23",property="ability_time23"),
			@Result(column="ability_level23",property="ability_level23"),
			@Result(column="ability_code24",property="ability_code24"),
			@Result(column="ability_time24",property="ability_time24"),
			@Result(column="ability_level24",property="ability_level24"),
			@Result(column="ability_code25",property="ability_code25"),
			@Result(column="ability_time25",property="ability_time25"),
			@Result(column="ability_level25",property="ability_level25")
	})
	User_mat selectUser_matByAccIdAndMatId(
			@Param("dota2_acc_id")Long acc_id,@Param("mat_id")Long mat_id);
	
	//保存用户详细信息(check)
	@InsertProvider(type=User_matDynaSqlProvider.class,method="save")
	void save(User_mat user_mat);
	//根据用户id与比赛编号选取比赛详情(check)
	@Select("SELECT * FROM " + USER_MAT_TABLE + " WHERE mat_id=#{mat_id_v} AND acc_id=#{acc_id_v}")
	@ResultMap("user_matMap")
	User_mat selectMatchByAccIdAndMatId(
			@Param("mat_id_v")Integer mat_id_v,@Param("acc_id_v")Integer acc_id_v);
	//查询此用户所有比赛详情(check)
	@Select("SELECT * FROM " + USER_MAT_TABLE+ " WHERE acc_id=#{acc_id_v}")
	@ResultMap("user_matMap")
	List<User_mat> selectUser_matByAccId(Long acc_id_v);
	//查询本局比赛的所有用户详情(check)
	@Select("SELECT * FROM " + USER_MAT_TABLE+ " WHERE mat_id=#{mat_id_v}")
	@ResultMap("user_matMap")
	List<User_mat> selectUser_matByMat_id(Long mat_id_v);
	//分页动态查询(check)
	@SelectProvider(type=User_matDynaSqlProvider.class, method="selectUser_matByParams")
	@ResultMap("user_matMap")
	List<User_mat> selectUser_matByParams(Map<String, Object> params);
	@UpdateProvider(type=User_matDynaSqlProvider.class,method="update")
	@ResultMap("user_matMap")
	void update(User_mat user_mat);
	//20场比赛
	@Select("SELECT radiant_win,lobby_type,solt,start FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=match_inf.mat_id order by start desc limit 20")
	List<DataOf20> select20Match(@Param("dota2_acc_id")Long acc_id);
	//20场天梯
	@Select("SELECT radiant_win,lobby_type,solt,start FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=match_inf.mat_id AND lobby_type=7 order by start desc limit 20")
	List<DataOf20> select20Match7(@Param("dota2_acc_id")Long acc_id);
	//特定场次的胜负情况
	@Select("SELECT radiant_win,lobby_type,solt,start FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=#{mat_id} AND user_mat_inf.mat_id=match_inf.mat_id")
	DataOf20 selectMatchVic(@Param("dota2_acc_id")Long acc_id,@Param("mat_id")Long mat_id);
	
	//所有比赛胜负
	@Select("SELECT radiant_win,lobby_type,solt FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=match_inf.mat_id ")
	List<DataOf20> selectMatch(@Param("dota2_acc_id")Long acc_id);
	//所有天梯胜负
	@Select("SELECT radiant_win,lobby_type,solt FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=match_inf.mat_id AND lobby_type=7 ")
	List<DataOf20> selectMatch7(@Param("dota2_acc_id")Long acc_id);
	//天梯比赛数量
	@Select("SELECT COUNT(*) FROM user_mat_inf INNER JOIN match_inf WHERE user_mat_inf.acc_id=#{dota2_acc_id} AND user_mat_inf.mat_id=match_inf.mat_id AND lobby_type=7 ")
	Integer selectMatch7Num(@Param("dota2_acc_id")Long acc_id);
}
