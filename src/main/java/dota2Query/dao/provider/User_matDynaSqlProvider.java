package dota2Query.dao.provider;

import java.sql.Savepoint;
import java.util.Map;

import dota2Query.domain.User_mat;

//import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.IfSqlNode;

import static dota2Query.util.common.Dota2Constants.*;
public class User_matDynaSqlProvider {
	public String save(final User_mat user_mat) {
		return new SQL() {
			{
				INSERT_INTO(USER_MAT_TABLE);
				VALUES("acc_id", "#{acc_id}");
				VALUES("mat_id", "#{mat_id}");
				VALUES("solt", "#{solt}");
				VALUES("hero_id", "#{hero_id}");
				VALUES("item0", "#{item0}");
				VALUES("item1", "#{item1}");
				VALUES("item2", "#{item2}");
				VALUES("item3", "#{item3}");
				VALUES("item4", "#{item4}");
				VALUES("item5", "#{item5}");
				VALUES("bac0", "#{bac0}");
				VALUES("bac1", "#{bac1}");
				VALUES("bac2", "#{bac2}");
				VALUES("bac3", "#{bac3}");
				VALUES("kill_num", "#{kill_num}");
				VALUES("deaths", "#{deaths}");
				VALUES("assists", "#{assists}");
				VALUES("leaver_status", "#{leaver_status}");
				VALUES("last_hit", "#{last_hit}");
				VALUES("denis", "#{denis}");
				VALUES("gpm", "#{gpm}");
				VALUES("xpm", "#{xpm}");
				VALUES("level", "#{level}");
				VALUES("hero_damage", "#{hero_damage}");
				VALUES("tower_damage", "#{tower_damage}");
				VALUES("hero_healing", "#{hero_healing}");
				VALUES("gold_spent", "#{gold_spent}");
				if(user_mat.getAbility_code1()!=null) {
					VALUES("ability_code1", "#{ability_code1}");
					VALUES("ability_time1", "#{ability_time1}");
					VALUES("ability_level1", "#{ability_level1}");
				}
				if(user_mat.getAbility_code2()!=null) {
					VALUES("ability_code2", "#{ability_code2}");
					VALUES("ability_time2", "#{ability_time2}");
					VALUES("ability_level2", "#{ability_level2}");
				}
				if(user_mat.getAbility_code3()!=null) {
					VALUES("ability_code3", "#{ability_code3}");
					VALUES("ability_time3", "#{ability_time3}");
					VALUES("ability_level3", "#{ability_level3}");
				}
				if(user_mat.getAbility_code4()!=null) {
					VALUES("ability_code4", "#{ability_code4}");
					VALUES("ability_time4", "#{ability_time4}");
					VALUES("ability_level4", "#{ability_level4}");
				}
				if(user_mat.getAbility_code5()!=null) {
					VALUES("ability_code5", "#{ability_code5}");
					VALUES("ability_time5", "#{ability_time5}");
					VALUES("ability_level5", "#{ability_level5}");
				}
				if(user_mat.getAbility_code6()!=null) {
					VALUES("ability_code6", "#{ability_code6}");
					VALUES("ability_time6", "#{ability_time6}");
					VALUES("ability_level6", "#{ability_level6}");
				}
				if(user_mat.getAbility_code7()!=null) {
					VALUES("ability_code7", "#{ability_code7}");
					VALUES("ability_time7", "#{ability_time7}");
					VALUES("ability_level7", "#{ability_level7}");
				}
				if(user_mat.getAbility_code8()!=null) {
					VALUES("ability_code8", "#{ability_code8}");
					VALUES("ability_time8", "#{ability_time8}");
					VALUES("ability_level8", "#{ability_level8}");
				}
				if(user_mat.getAbility_code9()!=null) {
					VALUES("ability_code9", "#{ability_code9}");
					VALUES("ability_time9", "#{ability_time9}");
					VALUES("ability_level9", "#{ability_level9}");
				}
				if(user_mat.getAbility_code10()!=null) {
					VALUES("ability_code10", "#{ability_code10}");
					VALUES("ability_time10", "#{ability_time10}");
					VALUES("ability_level10", "#{ability_level10}");
				}
				if(user_mat.getAbility_code11()!=null) {
					VALUES("ability_code11", "#{ability_code11}");
					VALUES("ability_time11", "#{ability_time11}");
					VALUES("ability_level11", "#{ability_level11}");
				}
				if(user_mat.getAbility_code12()!=null) {
					VALUES("ability_code12", "#{ability_code12}");
					VALUES("ability_time12", "#{ability_time12}");
					VALUES("ability_level12", "#{ability_level12}");
				}
				if(user_mat.getAbility_code13()!=null) {
					VALUES("ability_code13", "#{ability_code13}");
					VALUES("ability_time13", "#{ability_time13}");
					VALUES("ability_level13", "#{ability_level13}");
				}
				if(user_mat.getAbility_code14()!=null) {
					VALUES("ability_code14", "#{ability_code14}");
					VALUES("ability_time14", "#{ability_time14}");
					VALUES("ability_level14", "#{ability_level14}");
				}
				if(user_mat.getAbility_code15()!=null) {
					VALUES("ability_code15", "#{ability_code15}");
					VALUES("ability_time15", "#{ability_time15}");
					VALUES("ability_level15", "#{ability_level15}");
				}
				if(user_mat.getAbility_code16()!=null) {
					VALUES("ability_code16", "#{ability_code16}");
					VALUES("ability_time16", "#{ability_time16}");
					VALUES("ability_level16", "#{ability_level16}");
				}
				if(user_mat.getAbility_code17()!=null) {
					VALUES("ability_code17", "#{ability_code17}");
					VALUES("ability_time17", "#{ability_time17}");
					VALUES("ability_level17", "#{ability_level17}");
				}
				if(user_mat.getAbility_code18()!=null) {
					VALUES("ability_code18", "#{ability_code18}");
					VALUES("ability_time18", "#{ability_time18}");
					VALUES("ability_level18", "#{ability_level18}");
				}
				if(user_mat.getAbility_code19()!=null) {
					VALUES("ability_code19", "#{ability_code19}");
					VALUES("ability_time19", "#{ability_time19}");
					VALUES("ability_level19", "#{ability_level19}");
				}
				if(user_mat.getAbility_code20()!=null) {
					VALUES("ability_code20", "#{ability_code20}");
					VALUES("ability_time20", "#{ability_time20}");
					VALUES("ability_level20", "#{ability_level20}");
				}
				if(user_mat.getAbility_code21()!=null) {
					VALUES("ability_code21", "#{ability_code21}");
					VALUES("ability_time21", "#{ability_time21}");
					VALUES("ability_level21", "#{ability_level21}");
				}
				if(user_mat.getAbility_code22()!=null) {
					VALUES("ability_code22", "#{ability_code22}");
					VALUES("ability_time22", "#{ability_time22}");
					VALUES("ability_level22", "#{ability_level22}");
				}
				if(user_mat.getAbility_code23()!=null) {
					VALUES("ability_code23", "#{ability_code23}");
					VALUES("ability_time23", "#{ability_time23}");
					VALUES("ability_level23", "#{ability_level23}");
				}
				if(user_mat.getAbility_code24()!=null) {
					VALUES("ability_code24", "#{ability_code24}");
					VALUES("ability_time24", "#{ability_time24}");
					VALUES("ability_level24", "#{ability_level24}");
				}
				if(user_mat.getAbility_code25()!=null) {
					VALUES("ability_code25", "#{ability_code25}");
					VALUES("ability_time25", "#{ability_time25}");
					VALUES("ability_level25", "#{ability_level25}");
				}
			}
		}.toString();
	}
	//分页动态查询
	public String selectUser_matByParams(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(USER_MAT_TABLE);
				if (params.get("acc_id")!=null) {
					Long acc_id_v = (Long)params.get("acc_id");
					if(acc_id_v!=0)
						WHERE("  acc_id=#{acc_id}");
				}
			}
		}.toString();
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
		}
		return sql;
	}
	
	public String update(final User_mat user_mat) {
		return new SQL() {
			{
				UPDATE(USER_MAT_TABLE);
				SET("acc_id=#{acc_id}");
				SET("mat_id=#{mat_id}");
				SET("solt=#{solt}");
				SET("hero_id=#{hero_id}");
				SET("item0=#{item0}");
				SET("item1=#{item1}");
				SET("item2=#{item2}");
				SET("item3=#{item3}");
				SET("item4=#{item4}");
				SET("item5=#{item5}");
				SET("bac0=#{bac0}");
				SET("bac1=#{bac1}");
				SET("bac2=#{bac2}");
				SET("bac3=#{bac3}");
				SET("kill_num=#{kill_num}");
				SET("deaths=#{deaths}");
				SET("assists=#{assists}");
				SET("leaver_status=#{leaver_status}");
				SET("last_hit=#{last_hit}");
				SET("denis=#{denis}");
				SET("gpm=#{gpm}");
				SET("xpm=#{xpm}");
				SET("level=#{level}");
				SET("hero_damage=#{hero_damage}");
				SET("tower_damage=#{tower_damage}");
				SET("hero_healing=#{hero_healing}");
				SET("gold_spent=#{gold_spent}");
				if(user_mat.getAbility_code1()!=null) {
					SET("ability_code1=#{ability_code1}");
					SET("ability_time1=#{ability_time1}");
					SET("ability_level1=#{ability_level1}");
				}
				if(user_mat.getAbility_code2()!=null) {
					SET("ability_code2=#{ability_code2}");
					SET("ability_time2=#{ability_time2}");
					SET("ability_level2=#{ability_level2}");
				}
				if(user_mat.getAbility_code3()!=null) {
					SET("ability_code3=#{ability_code3}");
					SET("ability_time3=#{ability_time3}");
					SET("ability_level3=#{ability_level3}");
				}
				if(user_mat.getAbility_code4()!=null) {
					SET("ability_code4=#{ability_code4}");
					SET("ability_time4=#{ability_time4}");
					SET("ability_level4=#{ability_level4}");
				}
				if(user_mat.getAbility_code5()!=null) {
					SET("ability_code5=#{ability_code5}");
					SET("ability_time5=#{ability_time5}");
					SET("ability_level5=#{ability_level5}");
				}
				if(user_mat.getAbility_code6()!=null) {
					SET("ability_code6=#{ability_code6}");
					SET("ability_time6=#{ability_time6}");
					SET("ability_level6=#{ability_level6}");
				}
				if(user_mat.getAbility_code7()!=null) {
					SET("ability_code7=#{ability_code7}");
					SET("ability_time7=#{ability_time7}");
					SET("ability_level7=#{ability_level7}");
				}
				if(user_mat.getAbility_code8()!=null) {
					SET("ability_code8=#{ability_code8}");
					SET("ability_time8=#{ability_time8}");
					SET("ability_level8=#{ability_level8}");
				}
				if(user_mat.getAbility_code9()!=null) {
					SET("ability_code9=#{ability_code9}");
					SET("ability_time9=#{ability_time9}");
					SET("ability_level9=#{ability_level9}");
				}
				if(user_mat.getAbility_code10()!=null) {
					SET("ability_code10=#{ability_code10}");
					SET("ability_time10=#{ability_time10}");
					SET("ability_level10=#{ability_level10}");
				}
				if(user_mat.getAbility_code11()!=null) {
					SET("ability_code11=#{ability_code11}");
					SET("ability_time11=#{ability_time11}");
					SET("ability_level11=#{ability_level11}");
				}
				if(user_mat.getAbility_code12()!=null) {
					SET("ability_code12=#{ability_code12}");
					SET("ability_time12=#{ability_time12}");
					SET("ability_level12=#{ability_level12}");
				}
				if(user_mat.getAbility_code13()!=null) {
					SET("ability_code13=#{ability_code13}");
					SET("ability_time13=#{ability_time13}");
					SET("ability_level13=#{ability_level13}");
				}
				if(user_mat.getAbility_code14()!=null) {
					SET("ability_code14=#{ability_code14}");
					SET("ability_time14=#{ability_time14}");
					SET("ability_level14=#{ability_level14}");
				}
				if(user_mat.getAbility_code15()!=null) {
					SET("ability_code15=#{ability_code15}");
					SET("ability_time15=#{ability_time15}");
					SET("ability_level15=#{ability_level15}");
				}
				if(user_mat.getAbility_code16()!=null) {
					SET("ability_code16=#{ability_code16}");
					SET("ability_time16=#{ability_time16}");
					SET("ability_level16=#{ability_level16}");
				}
				if(user_mat.getAbility_code17()!=null) {
					SET("ability_code17=#{ability_code17}");
					SET("ability_time17=#{ability_time17}");
					SET("ability_level17=#{ability_level17}");
				}
				if(user_mat.getAbility_code18()!=null) {
					SET("ability_code18=#{ability_code18}");
					SET("ability_time18=#{ability_time18}");
					SET("ability_level18=#{ability_level18}");
				}
				if(user_mat.getAbility_code19()!=null) {
					SET("ability_code19=#{ability_code19}");
					SET("ability_time19=#{ability_time19}");
					SET("ability_level19=#{ability_level19}");
				}
				if(user_mat.getAbility_code20()!=null) {
					SET("ability_code20=#{ability_code20}");
					SET("ability_time20=#{ability_time20}");
					SET("ability_level20=#{ability_level20}");
				}
				if(user_mat.getAbility_code21()!=null) {
					SET("ability_code21=#{ability_code21}");
					SET("ability_time21=#{ability_time21}");
					SET("ability_level21=#{ability_level21}");
				}
				if(user_mat.getAbility_code22()!=null) {
					SET("ability_code22=#{ability_code22}");
					SET("ability_time22=#{ability_time22}");
					SET("ability_level22=#{ability_level22}");
				}
				if(user_mat.getAbility_code23()!=null) {
					SET("ability_code23=#{ability_code23}");
					SET("ability_time23=#{ability_time23}");
					SET("ability_level23=#{ability_level23}");
				}
				if(user_mat.getAbility_code24()!=null) {
					SET("ability_code24=#{ability_code24}");
					SET("ability_time24=#{ability_time24}");
					SET("ability_level24=#{ability_level24}");
				}
				if(user_mat.getAbility_code25()!=null) {
					SET("ability_code25=#{ability_code25}");
					SET("ability_time25=#{ability_time25}");
					SET("ability_level25=#{ability_level25}");
				}
				WHERE(" acc_id=#{acc_id}");
			}
		}.toString();
	}
}
