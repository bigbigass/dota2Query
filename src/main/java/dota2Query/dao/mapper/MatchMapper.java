package dota2Query.dao.mapper;

import org.apache.ibatis.annotations.Select;

import dota2Query.domain.Match;

import static dota2Query.util.common.Dota2Constants.*;

import java.util.List;
public interface MatchMapper {
	@Select("SELECT * FROM " + MATCHTABLE+" WHERE mat_id=#{mat_id}")
	Match selectMatchById(long mat_id);
	
	@Select("SELECT * FROM "+MATCHTABLE+" WHERE mat_id IN (SELECT mat_id FROM "+
	USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id})")
	List<Match> selectMatchByUserId(long dota2_acc_id);
	
	@Select("SELECT mat_id FROM "+MATCHTABLE+" WHERE mat_id IN (SELECT mat_id FROM "+
			USER_MAT_TABLE+" WHERE acc_id=#{dota2_acc_id}) order by start desc limit 1")
	Long selectNewMatch(Long dota2_acc_id);
}
