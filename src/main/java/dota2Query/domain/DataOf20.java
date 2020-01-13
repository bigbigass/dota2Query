package dota2Query.domain;

import java.io.Serializable;

public class DataOf20 implements Serializable{
	private int radiant_win;
	private int lobby_type;
	private int solt;
	private Long start;
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public int getRadiant_win() {
		return radiant_win;
	}
	public void setRadiant_win(int radiant_win) {
		this.radiant_win = radiant_win;
	}
	public int getLobby_type() {
		return lobby_type;
	}
	public void setLobby_type(int lobby_type) {
		this.lobby_type = lobby_type;
	}
	public int getSolt() {
		return solt;
	}
	public void setSolt(int solt) {
		this.solt = solt;
	}
}
