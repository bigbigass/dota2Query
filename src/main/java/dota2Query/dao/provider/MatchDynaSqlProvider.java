package dota2Query.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import dota2Query.domain.Match;

import static dota2Query.util.common.Dota2Constants.*;
public class MatchDynaSqlProvider {
	//保存比赛
	public String save(final Match match) {
		return new SQL() {
			{
				INSERT_INTO(MATCHTABLE);
				VALUES("mat_id", "#{mat_id}");
				VALUES("seq", "#{seq}");
				VALUES("start", "#{start}");
				VALUES("duration", "#{duration}");
				VALUES("radiant_win", "#{radiant_win}");
				VALUES("cluster", "#{cluster}");
				VALUES("first_blood_time", "#{first_blood_time}");
				VALUES("lobby_type", "#{lobby_type}");
				VALUES("leagueid", "#{leagueid}");
				VALUES("game_mode", "#{game_mode}");
				VALUES("radiant_score", "#{radiant_score}");
				VALUES("dire_score", "#{dire_score}");
			}
		}.toString();
	}
	//动态查询
	public String selectMatchByParams(final Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(MATCHTABLE);
				if(params.get("acc_id")!=null) {
					Long acc_id_v = (Long)params.get("acc_id");
					if(acc_id_v!=0)
					WHERE(" mat_id ");
				}
			}
		}.toString();
		sql+="IN (SELECT mat_id FROM user_mat_inf WHERE acc_id=#{acc_id}) order by start desc";
		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
		}
		return sql;
	}
}
