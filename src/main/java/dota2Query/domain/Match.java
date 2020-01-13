package dota2Query.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(value = { "handler" })
public class Match implements Serializable{
	public Match() {}
	
	public Match(Long mat_id, Long seq, Long start, Integer duration, Integer radiant_win, Integer cluster,
			Integer first_blood_time, Integer lobby_type, Integer leagueid, Integer game_mode, Integer radiant_score,
			Integer dire_score, List<User> users, List<User_mat> user_mats) {
		super();
		this.mat_id = mat_id;
		this.seq = seq;
		this.start = start;
		this.duration = duration;
		this.radiant_win = radiant_win;
		this.cluster = cluster;
		this.first_blood_time = first_blood_time;
		this.lobby_type = lobby_type;
		this.leagueid = leagueid;
		this.game_mode = game_mode;
		this.radiant_score = radiant_score;
		this.dire_score = dire_score;
		this.users = users;
		this.user_mats = user_mats;
	}
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	private Long mat_id;//比赛编号
	private Long seq;//比赛序列号
	private Long start;//时间戳
	private Integer duration;//比赛时间，单位s
	private Integer radiant_win;//天辉是否胜利
	private Integer cluster;//服务器地区
	private Integer first_blood_time;//一血时间
	private Integer lobby_type;//比赛类型
	private Integer leagueid;//联赛id
	private Integer game_mode;//比赛模式
	private Integer radiant_score;//天辉人头
	private Integer dire_score;//夜魇人头
	private List<User> users;//本局比赛用户
	private List<User_mat> user_mats;//本剧比赛用户详细信息


	public Long getMat_id() {
		return mat_id;
	}
	public void setMat_id(Long mat_id) {
		this.mat_id = mat_id;
	}
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getRadiant_win() {
		return radiant_win;
	}
	public void setRadiant_win(Integer radiant_win) {
		this.radiant_win = radiant_win;
	}
	public Integer getCluster() {
		return cluster;
	}
	public void setCluster(Integer cluster) {
		this.cluster = cluster;
	}
	public Integer getFirst_blood_time() {
		return first_blood_time;
	}
	public void setFirst_blood_time(Integer first_blood_time) {
		this.first_blood_time = first_blood_time;
	}
	public Integer getLobby_type() {
		return lobby_type;
	}
	public void setLobby_type(Integer lobby_type) {
		this.lobby_type = lobby_type;
	}
	public Integer getLeagueid() {
		return leagueid;
	}
	public void setLeagueid(Integer leagueid) {
		this.leagueid = leagueid;
	}
	public Integer getGame_mode() {
		return game_mode;
	}
	public void setGame_mode(Integer game_mode) {
		this.game_mode = game_mode;
	}
	public Integer getRadiant_score() {
		return radiant_score;
	}
	public void setRadiant_score(Integer radiant_score) {
		this.radiant_score = radiant_score;
	}
	public Integer getDire_score() {
		return dire_score;
	}
	public void setDire_score(Integer dire_score) {
		this.dire_score = dire_score;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<User_mat> getUser_mats() {
		return user_mats;
	}
	public void setUser_mats(List<User_mat> user_mats) {
		this.user_mats = user_mats;
	}
	@Override
	public String toString() {
		return "Match [mat_id=" + mat_id + ", seq=" + seq + ", start=" + start + ", duration=" + duration
				+ ", radiant_win=" + radiant_win + ", cluster=" + cluster + ", first_blood_time=" + first_blood_time
				+ ", lobby_type=" + lobby_type + ", leagueid=" + leagueid + ", game_mode=" + game_mode
				+ ", radiant_score=" + radiant_score + ", dire_score=" + dire_score + ", users=" + users
				+ ", user_mats=" + user_mats + "]";
	}
}
