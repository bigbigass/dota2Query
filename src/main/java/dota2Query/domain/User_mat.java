package dota2Query.domain;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dota2Query.domain.*;
@JsonIgnoreProperties(value = { "handler" })
public class User_mat implements Serializable{
	public User_mat() {}
	
	public User_mat(Long acc_id, Long mat_id, Integer solt, Integer hero_id, Integer item0, Integer item1, Integer item2,
			Integer item3, Integer item4, Integer item5, Integer bac0, Integer bac1, Integer bac2, Integer bac3, Integer kill_num,
			Integer deaths, Integer assists, Integer leaver_status, Integer last_hit, Integer denis, Integer gpm,
			Integer xpm, Integer level, Integer hero_damage, Integer tower_damage, Integer hero_healing,
			Integer gold_spent, Integer ability_code1, Integer ability_time1, Integer ability_level1,
			Integer ability_code2, Integer ability_time2, Integer ability_level2, Integer ability_code3,
			Integer ability_time3, Integer ability_level3, Integer ability_code4, Integer ability_time4,
			Integer ability_level4, Integer ability_code5, Integer ability_time5, Integer ability_level5,
			Integer ability_code6, Integer ability_time6, Integer ability_level6, Integer ability_code7,
			Integer ability_time7, Integer ability_level7, Integer ability_code8, Integer ability_time8,
			Integer ability_level8, Integer ability_code9, Integer ability_time9, Integer ability_level9,
			Integer ability_code10, Integer ability_time10, Integer ability_level10, Integer ability_code11,
			Integer ability_time11, Integer ability_level11, Integer ability_code12, Integer ability_time12,
			Integer ability_level12, Integer ability_code13, Integer ability_time13, Integer ability_level13,
			Integer ability_code14, Integer ability_time14, Integer ability_level14, Integer ability_code15,
			Integer ability_time15, Integer ability_level15, Integer ability_code16, Integer ability_time16,
			Integer ability_level16, Integer ability_code17, Integer ability_time17, Integer ability_level17,
			Integer ability_code18, Integer ability_time18, Integer ability_level18, Integer ability_code19,
			Integer ability_time19, Integer ability_level19, Integer ability_code20, Integer ability_time20,
			Integer ability_level20, Integer ability_code21, Integer ability_time21, Integer ability_level21,
			Integer ability_code22, Integer ability_time22, Integer ability_level22, Integer ability_code23,
			Integer ability_time23, Integer ability_level23, Integer ability_code24, Integer ability_time24,
			Integer ability_level24, Integer ability_code25, Integer ability_time25, Integer ability_level25) {
		super();
		this.acc_id = acc_id;
		this.mat_id = mat_id;
		this.solt = solt;
		this.hero_id = hero_id;
		this.item0 = item0;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.bac0 = bac0;
		this.bac1 = bac1;
		this.bac2 = bac2;
		this.bac3 = bac3;
		this.kill_num = kill_num;
		this.deaths = deaths;
		this.assists = assists;
		this.leaver_status = leaver_status;
		this.last_hit = last_hit;
		this.denis = denis;
		this.gpm = gpm;
		this.xpm = xpm;
		this.level = level;
		this.hero_damage = hero_damage;
		this.tower_damage = tower_damage;
		this.hero_healing = hero_healing;
		this.gold_spent = gold_spent;
		this.ability_code1 = ability_code1;
		this.ability_time1 = ability_time1;
		this.ability_level1 = ability_level1;
		this.ability_code2 = ability_code2;
		this.ability_time2 = ability_time2;
		this.ability_level2 = ability_level2;
		this.ability_code3 = ability_code3;
		this.ability_time3 = ability_time3;
		this.ability_level3 = ability_level3;
		this.ability_code4 = ability_code4;
		this.ability_time4 = ability_time4;
		this.ability_level4 = ability_level4;
		this.ability_code5 = ability_code5;
		this.ability_time5 = ability_time5;
		this.ability_level5 = ability_level5;
		this.ability_code6 = ability_code6;
		this.ability_time6 = ability_time6;
		this.ability_level6 = ability_level6;
		this.ability_code7 = ability_code7;
		this.ability_time7 = ability_time7;
		this.ability_level7 = ability_level7;
		this.ability_code8 = ability_code8;
		this.ability_time8 = ability_time8;
		this.ability_level8 = ability_level8;
		this.ability_code9 = ability_code9;
		this.ability_time9 = ability_time9;
		this.ability_level9 = ability_level9;
		this.ability_code10 = ability_code10;
		this.ability_time10 = ability_time10;
		this.ability_level10 = ability_level10;
		this.ability_code11 = ability_code11;
		this.ability_time11 = ability_time11;
		this.ability_level11 = ability_level11;
		this.ability_code12 = ability_code12;
		this.ability_time12 = ability_time12;
		this.ability_level12 = ability_level12;
		this.ability_code13 = ability_code13;
		this.ability_time13 = ability_time13;
		this.ability_level13 = ability_level13;
		this.ability_code14 = ability_code14;
		this.ability_time14 = ability_time14;
		this.ability_level14 = ability_level14;
		this.ability_code15 = ability_code15;
		this.ability_time15 = ability_time15;
		this.ability_level15 = ability_level15;
		this.ability_code16 = ability_code16;
		this.ability_time16 = ability_time16;
		this.ability_level16 = ability_level16;
		this.ability_code17 = ability_code17;
		this.ability_time17 = ability_time17;
		this.ability_level17 = ability_level17;
		this.ability_code18 = ability_code18;
		this.ability_time18 = ability_time18;
		this.ability_level18 = ability_level18;
		this.ability_code19 = ability_code19;
		this.ability_time19 = ability_time19;
		this.ability_level19 = ability_level19;
		this.ability_code20 = ability_code20;
		this.ability_time20 = ability_time20;
		this.ability_level20 = ability_level20;
		this.ability_code21 = ability_code21;
		this.ability_time21 = ability_time21;
		this.ability_level21 = ability_level21;
		this.ability_code22 = ability_code22;
		this.ability_time22 = ability_time22;
		this.ability_level22 = ability_level22;
		this.ability_code23 = ability_code23;
		this.ability_time23 = ability_time23;
		this.ability_level23 = ability_level23;
		this.ability_code24 = ability_code24;
		this.ability_time24 = ability_time24;
		this.ability_level24 = ability_level24;
		this.ability_code25 = ability_code25;
		this.ability_time25 = ability_time25;
		this.ability_level25 = ability_level25;
	}
	private Long id;
	private Long acc_id;
	private Long mat_id;
	private Integer solt;//8位无符号整数，标识了玩家在队伍中位置
	private Integer hero_id;//英雄
	private Integer item0=0;
	private Integer item1=0;
	private Integer item2=0;
	private Integer item3=0;
	private Integer item4=0;
	public Integer getBac3() {
		return bac3;
	}

	public void setBac3(Integer bac3) {
		this.bac3 = bac3;
	}
	private Integer item5=0;
	private Integer bac0=0;
	private Integer bac1=0;
	private Integer bac2=0;
	private Integer bac3=0;
	private Integer kill_num;//人头
	private Integer deaths;//死亡数
	private Integer assists;//助攻
	private Integer leaver_status;//比赛状态，例如是否秒退
	private Integer last_hit;//正补
	private Integer denis;//反补
	private Integer gpm=0;
	private Integer xpm=0;
	private Integer level;//等级
	private Integer hero_damage=0;//伤害
	private Integer tower_damage=0;//塔伤害
	private Integer hero_healing=0;//治疗
	private Integer gold_spent=0;//总花费经济
	private Integer ability_code1;
	private Integer ability_time1;
	private Integer ability_level1;
	private Integer ability_code2;
	private Integer ability_time2;
	private Integer ability_level2;
	private Integer ability_code3;
	private Integer ability_time3;
	private Integer ability_level3;
	private Integer ability_code4;
	private Integer ability_time4;
	private Integer ability_level4;
	private Integer ability_code5;
	private Integer ability_time5;
	private Integer ability_level5;
	private Integer ability_code6;
	private Integer ability_time6;
	private Integer ability_level6;
	private Integer ability_code7;
	private Integer ability_time7;
	private Integer ability_level7;
	private Integer ability_code8;
	private Integer ability_time8;
	private Integer ability_level8;
	private Integer ability_code9;
	private Integer ability_time9;
	private Integer ability_level9;
	private Integer ability_code10;
	private Integer ability_time10;
	private Integer ability_level10;
	private Integer ability_code11;
	private Integer ability_time11;
	private Integer ability_level11;
	private Integer ability_code12;
	private Integer ability_time12;
	private Integer ability_level12;
	private Integer ability_code13;
	private Integer ability_time13;
	private Integer ability_level13;
	private Integer ability_code14;
	private Integer ability_time14;
	private Integer ability_level14;
	private Integer ability_code15;
	private Integer ability_time15;
	private Integer ability_level15;
	private Integer ability_code16;
	private Integer ability_time16;
	private Integer ability_level16;
	private Integer ability_code17;
	private Integer ability_time17;
	private Integer ability_level17;
	private Integer ability_code18;
	private Integer ability_time18;
	private Integer ability_level18;
	private Integer ability_code19;
	private Integer ability_time19;
	private Integer ability_level19;
	private Integer ability_code20;
	private Integer ability_time20;
	private Integer ability_level20;
	private Integer ability_code21;
	private Integer ability_time21;
	private Integer ability_level21;
	private Integer ability_code22;
	private Integer ability_time22;
	private Integer ability_level22;
	private Integer ability_code23;
	private Integer ability_time23;
	private Integer ability_level23;
	private Integer ability_code24;
	private Integer ability_time24;
	private Integer ability_level24;
	private Integer ability_code25;
	private Integer ability_time25;
	private Integer ability_level25;

	public Integer getSolt() {
		return solt;
	}
	public void setSolt(Integer solt) {
		this.solt = solt;
	}
	public Integer getHero_id() {
		return hero_id;
	}
	public void setHero_id(Integer hero_id) {
		this.hero_id = hero_id;
	}
	public Integer getItem0() {
		return item0;
	}
	public void setItem0(Integer item0) {
		this.item0 = item0;
	}
	public Integer getItem1() {
		return item1;
	}
	public void setItem1(Integer item1) {
		this.item1 = item1;
	}
	public Integer getItem2() {
		return item2;
	}
	public void setItem2(Integer item2) {
		this.item2 = item2;
	}
	public Integer getItem3() {
		return item3;
	}
	public void setItem3(Integer item3) {
		this.item3 = item3;
	}
	public Integer getItem4() {
		return item4;
	}
	public void setItem4(Integer item4) {
		this.item4 = item4;
	}
	public Integer getItem5() {
		return item5;
	}
	public void setItem5(Integer item5) {
		this.item5 = item5;
	}
	public Integer getBac0() {
		return bac0;
	}
	public void setBac0(Integer bac0) {
		this.bac0 = bac0;
	}
	public Integer getBac1() {
		return bac1;
	}
	public void setBac1(Integer bac1) {
		this.bac1 = bac1;
	}
	public Integer getBac2() {
		return bac2;
	}
	public void setBac2(Integer bac2) {
		this.bac2 = bac2;
	}
	public Integer getKill_num() {
		return kill_num;
	}
	public void setKill_num(Integer kill_num) {
		this.kill_num = kill_num;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public Integer getAssists() {
		return assists;
	}
	public void setAssists(Integer assists) {
		this.assists = assists;
	}
	public Integer getLeaver_status() {
		return leaver_status;
	}
	public void setLeaver_status(Integer leaver_status) {
		this.leaver_status = leaver_status;
	}
	public Integer getLast_hit() {
		return last_hit;
	}
	public void setLast_hit(Integer last_hit) {
		this.last_hit = last_hit;
	}
	public Integer getDenis() {
		return denis;
	}
	public void setDenis(Integer denis) {
		this.denis = denis;
	}
	public Integer getGpm() {
		return gpm;
	}
	public void setGpm(Integer gpm) {
		this.gpm = gpm;
	}
	public Integer getXpm() {
		return xpm;
	}
	public void setXpm(Integer xpm) {
		this.xpm = xpm;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getHero_damage() {
		return hero_damage;
	}
	public void setHero_damage(Integer hero_damage) {
		this.hero_damage = hero_damage;
	}
	public Integer getTower_damage() {
		return tower_damage;
	}
	public void setTower_damage(Integer tower_damage) {
		this.tower_damage = tower_damage;
	}
	public Integer getHero_healing() {
		return hero_healing;
	}
	public void setHero_healing(Integer hero_healing) {
		this.hero_healing = hero_healing;
	}
	public Integer getGold_spent() {
		return gold_spent;
	}
	public void setGold_spent(Integer gold_spent) {
		this.gold_spent = gold_spent;
	}
	public Integer getAbility_code1() {
		return ability_code1;
	}
	public void setAbility_code1(Integer ability_code1) {
		this.ability_code1 = ability_code1;
	}
	public Integer getAbility_time1() {
		return ability_time1;
	}
	public void setAbility_time1(Integer ability_time1) {
		this.ability_time1 = ability_time1;
	}
	public Integer getAbility_level1() {
		return ability_level1;
	}
	public void setAbility_level1(Integer ability_level1) {
		this.ability_level1 = ability_level1;
	}
	public Integer getAbility_code2() {
		return ability_code2;
	}
	public void setAbility_code2(Integer ability_code2) {
		this.ability_code2 = ability_code2;
	}
	public Integer getAbility_time2() {
		return ability_time2;
	}
	public void setAbility_time2(Integer ability_time2) {
		this.ability_time2 = ability_time2;
	}
	public Integer getAbility_level2() {
		return ability_level2;
	}
	public void setAbility_level2(Integer ability_level2) {
		this.ability_level2 = ability_level2;
	}
	public Integer getAbility_code3() {
		return ability_code3;
	}
	public void setAbility_code3(Integer ability_code3) {
		this.ability_code3 = ability_code3;
	}
	public Integer getAbility_time3() {
		return ability_time3;
	}
	public void setAbility_time3(Integer ability_time3) {
		this.ability_time3 = ability_time3;
	}
	public Integer getAbility_level3() {
		return ability_level3;
	}
	public void setAbility_level3(Integer ability_level3) {
		this.ability_level3 = ability_level3;
	}
	public Integer getAbility_code4() {
		return ability_code4;
	}
	public void setAbility_code4(Integer ability_code4) {
		this.ability_code4 = ability_code4;
	}
	public Integer getAbility_time4() {
		return ability_time4;
	}
	public void setAbility_time4(Integer ability_time4) {
		this.ability_time4 = ability_time4;
	}
	public Integer getAbility_level4() {
		return ability_level4;
	}
	public void setAbility_level4(Integer ability_level4) {
		this.ability_level4 = ability_level4;
	}
	public Integer getAbility_code5() {
		return ability_code5;
	}
	public void setAbility_code5(Integer ability_code5) {
		this.ability_code5 = ability_code5;
	}
	public Integer getAbility_time5() {
		return ability_time5;
	}
	public void setAbility_time5(Integer ability_time5) {
		this.ability_time5 = ability_time5;
	}
	public Integer getAbility_level5() {
		return ability_level5;
	}
	public void setAbility_level5(Integer ability_level5) {
		this.ability_level5 = ability_level5;
	}
	public Integer getAbility_code6() {
		return ability_code6;
	}
	public void setAbility_code6(Integer ability_code6) {
		this.ability_code6 = ability_code6;
	}
	public Integer getAbility_time6() {
		return ability_time6;
	}
	public void setAbility_time6(Integer ability_time6) {
		this.ability_time6 = ability_time6;
	}
	public Integer getAbility_level6() {
		return ability_level6;
	}
	public void setAbility_level6(Integer ability_level6) {
		this.ability_level6 = ability_level6;
	}
	public Integer getAbility_code7() {
		return ability_code7;
	}
	public void setAbility_code7(Integer ability_code7) {
		this.ability_code7 = ability_code7;
	}
	public Integer getAbility_time7() {
		return ability_time7;
	}
	public void setAbility_time7(Integer ability_time7) {
		this.ability_time7 = ability_time7;
	}
	public Integer getAbility_level7() {
		return ability_level7;
	}
	public void setAbility_level7(Integer ability_level7) {
		this.ability_level7 = ability_level7;
	}
	public Integer getAbility_code8() {
		return ability_code8;
	}
	public void setAbility_code8(Integer ability_code8) {
		this.ability_code8 = ability_code8;
	}
	public Integer getAbility_time8() {
		return ability_time8;
	}
	public void setAbility_time8(Integer ability_time8) {
		this.ability_time8 = ability_time8;
	}
	public Integer getAbility_level8() {
		return ability_level8;
	}
	public void setAbility_level8(Integer ability_level8) {
		this.ability_level8 = ability_level8;
	}
	public Integer getAbility_code9() {
		return ability_code9;
	}
	public void setAbility_code9(Integer ability_code9) {
		this.ability_code9 = ability_code9;
	}
	public Integer getAbility_time9() {
		return ability_time9;
	}
	public void setAbility_time9(Integer ability_time9) {
		this.ability_time9 = ability_time9;
	}
	public Integer getAbility_level9() {
		return ability_level9;
	}
	public void setAbility_level9(Integer ability_level9) {
		this.ability_level9 = ability_level9;
	}
	public Integer getAbility_code10() {
		return ability_code10;
	}
	public void setAbility_code10(Integer ability_code10) {
		this.ability_code10 = ability_code10;
	}
	public Integer getAbility_time10() {
		return ability_time10;
	}
	public void setAbility_time10(Integer ability_time10) {
		this.ability_time10 = ability_time10;
	}
	public Integer getAbility_level10() {
		return ability_level10;
	}
	public void setAbility_level10(Integer ability_level10) {
		this.ability_level10 = ability_level10;
	}
	public Integer getAbility_code11() {
		return ability_code11;
	}
	public void setAbility_code11(Integer ability_code11) {
		this.ability_code11 = ability_code11;
	}
	public Integer getAbility_time11() {
		return ability_time11;
	}
	public void setAbility_time11(Integer ability_time11) {
		this.ability_time11 = ability_time11;
	}
	public Integer getAbility_level11() {
		return ability_level11;
	}
	public void setAbility_level11(Integer ability_level11) {
		this.ability_level11 = ability_level11;
	}
	public Integer getAbility_code12() {
		return ability_code12;
	}
	public void setAbility_code12(Integer ability_code12) {
		this.ability_code12 = ability_code12;
	}
	public Integer getAbility_time12() {
		return ability_time12;
	}
	public void setAbility_time12(Integer ability_time12) {
		this.ability_time12 = ability_time12;
	}
	public Integer getAbility_level12() {
		return ability_level12;
	}
	public void setAbility_level12(Integer ability_level12) {
		this.ability_level12 = ability_level12;
	}
	public Integer getAbility_code13() {
		return ability_code13;
	}
	public void setAbility_code13(Integer ability_code13) {
		this.ability_code13 = ability_code13;
	}
	public Integer getAbility_time13() {
		return ability_time13;
	}
	public void setAbility_time13(Integer ability_time13) {
		this.ability_time13 = ability_time13;
	}
	public Integer getAbility_level13() {
		return ability_level13;
	}
	public void setAbility_level13(Integer ability_level13) {
		this.ability_level13 = ability_level13;
	}
	public Integer getAbility_code14() {
		return ability_code14;
	}
	public void setAbility_code14(Integer ability_code14) {
		this.ability_code14 = ability_code14;
	}
	public Integer getAbility_time14() {
		return ability_time14;
	}
	public void setAbility_time14(Integer ability_time14) {
		this.ability_time14 = ability_time14;
	}
	public Integer getAbility_level14() {
		return ability_level14;
	}
	public void setAbility_level14(Integer ability_level14) {
		this.ability_level14 = ability_level14;
	}
	public Integer getAbility_code15() {
		return ability_code15;
	}
	public void setAbility_code15(Integer ability_code15) {
		this.ability_code15 = ability_code15;
	}
	public Integer getAbility_time15() {
		return ability_time15;
	}
	public void setAbility_time15(Integer ability_time15) {
		this.ability_time15 = ability_time15;
	}
	public Integer getAbility_level15() {
		return ability_level15;
	}
	public void setAbility_level15(Integer ability_level15) {
		this.ability_level15 = ability_level15;
	}
	public Integer getAbility_code16() {
		return ability_code16;
	}
	public void setAbility_code16(Integer ability_code16) {
		this.ability_code16 = ability_code16;
	}
	public Integer getAbility_time16() {
		return ability_time16;
	}
	public void setAbility_time16(Integer ability_time16) {
		this.ability_time16 = ability_time16;
	}
	public Integer getAbility_level16() {
		return ability_level16;
	}
	public void setAbility_level16(Integer ability_level16) {
		this.ability_level16 = ability_level16;
	}
	public Integer getAbility_code17() {
		return ability_code17;
	}
	public void setAbility_code17(Integer ability_code17) {
		this.ability_code17 = ability_code17;
	}
	public Integer getAbility_time17() {
		return ability_time17;
	}
	public void setAbility_time17(Integer ability_time17) {
		this.ability_time17 = ability_time17;
	}
	public Integer getAbility_level17() {
		return ability_level17;
	}
	public void setAbility_level17(Integer ability_level17) {
		this.ability_level17 = ability_level17;
	}
	public Integer getAbility_code18() {
		return ability_code18;
	}
	public void setAbility_code18(Integer ability_code18) {
		this.ability_code18 = ability_code18;
	}
	public Integer getAbility_time18() {
		return ability_time18;
	}
	public void setAbility_time18(Integer ability_time18) {
		this.ability_time18 = ability_time18;
	}
	public Integer getAbility_level18() {
		return ability_level18;
	}
	public void setAbility_level18(Integer ability_level18) {
		this.ability_level18 = ability_level18;
	}
	public Integer getAbility_code19() {
		return ability_code19;
	}
	public void setAbility_code19(Integer ability_code19) {
		this.ability_code19 = ability_code19;
	}
	public Integer getAbility_time19() {
		return ability_time19;
	}
	public void setAbility_time19(Integer ability_time19) {
		this.ability_time19 = ability_time19;
	}
	public Integer getAbility_level19() {
		return ability_level19;
	}
	public void setAbility_level19(Integer ability_level19) {
		this.ability_level19 = ability_level19;
	}
	public Integer getAbility_code20() {
		return ability_code20;
	}
	public void setAbility_code20(Integer ability_code20) {
		this.ability_code20 = ability_code20;
	}
	public Integer getAbility_time20() {
		return ability_time20;
	}
	public void setAbility_time20(Integer ability_time20) {
		this.ability_time20 = ability_time20;
	}
	public Integer getAbility_level20() {
		return ability_level20;
	}
	public void setAbility_level20(Integer ability_level20) {
		this.ability_level20 = ability_level20;
	}
	public Integer getAbility_code21() {
		return ability_code21;
	}
	public void setAbility_code21(Integer ability_code21) {
		this.ability_code21 = ability_code21;
	}
	public Integer getAbility_time21() {
		return ability_time21;
	}
	public void setAbility_time21(Integer ability_time21) {
		this.ability_time21 = ability_time21;
	}
	public Integer getAbility_level21() {
		return ability_level21;
	}
	public void setAbility_level21(Integer ability_level21) {
		this.ability_level21 = ability_level21;
	}
	public Integer getAbility_code22() {
		return ability_code22;
	}
	public void setAbility_code22(Integer ability_code22) {
		this.ability_code22 = ability_code22;
	}
	public Integer getAbility_time22() {
		return ability_time22;
	}
	public void setAbility_time22(Integer ability_time22) {
		this.ability_time22 = ability_time22;
	}
	public Integer getAbility_level22() {
		return ability_level22;
	}
	public void setAbility_level22(Integer ability_level22) {
		this.ability_level22 = ability_level22;
	}
	public Integer getAbility_code23() {
		return ability_code23;
	}
	public void setAbility_code23(Integer ability_code23) {
		this.ability_code23 = ability_code23;
	}
	public Integer getAbility_time23() {
		return ability_time23;
	}
	public void setAbility_time23(Integer ability_time23) {
		this.ability_time23 = ability_time23;
	}
	public Integer getAbility_level23() {
		return ability_level23;
	}
	public void setAbility_level23(Integer ability_level23) {
		this.ability_level23 = ability_level23;
	}
	public Integer getAbility_code24() {
		return ability_code24;
	}
	public void setAbility_code24(Integer ability_code24) {
		this.ability_code24 = ability_code24;
	}
	public Integer getAbility_time24() {
		return ability_time24;
	}
	public void setAbility_time24(Integer ability_time24) {
		this.ability_time24 = ability_time24;
	}
	public Integer getAbility_level24() {
		return ability_level24;
	}
	public void setAbility_level24(Integer ability_level24) {
		this.ability_level24 = ability_level24;
	}
	public Integer getAbility_code25() {
		return ability_code25;
	}
	public void setAbility_code25(Integer ability_code25) {
		this.ability_code25 = ability_code25;
	}
	public Integer getAbility_time25() {
		return ability_time25;
	}
	public void setAbility_time25(Integer ability_time25) {
		this.ability_time25 = ability_time25;
	}
	public Integer getAbility_level25() {
		return ability_level25;
	}
	public void setAbility_level25(Integer ability_level25) {
		this.ability_level25 = ability_level25;
	}

	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public Long getMat_id() {
		return mat_id;
	}

	public void setMat_id(Long mat_id) {
		this.mat_id = mat_id;
	}

	@Override
	public String toString() {
		return "User_mat [acc_id=" + acc_id + ", mat_id=" + mat_id + ", solt=" + solt + ", hero_id=" + hero_id
				+ ", item0=" + item0 + ", item1=" + item1 + ", item2=" + item2 + ", item3=" + item3 + ", item4=" + item4
				+ ", item5=" + item5 + ", bac0=" + bac0 + ", bac1=" + bac1 + ", bac2=" + bac2 + ", kill_num=" + kill_num
				+ ", deaths=" + deaths + ", assists=" + assists + ", leaver_status=" + leaver_status + ", last_hit="
				+ last_hit + ", denis=" + denis + ", gpm=" + gpm + ", xpm=" + xpm + ", level=" + level
				+ ", hero_damage=" + hero_damage + ", tower_damage=" + tower_damage + ", hero_healing=" + hero_healing
				+ ", gold_spent=" + gold_spent + ", ability_code1=" + ability_code1 + ", ability_time1=" + ability_time1
				+ ", ability_level1=" + ability_level1 + ", ability_code2=" + ability_code2 + ", ability_time2="
				+ ability_time2 + ", ability_level2=" + ability_level2 + ", ability_code3=" + ability_code3
				+ ", ability_time3=" + ability_time3 + ", ability_level3=" + ability_level3 + ", ability_code4="
				+ ability_code4 + ", ability_time4=" + ability_time4 + ", ability_level4=" + ability_level4
				+ ", ability_code5=" + ability_code5 + ", ability_time5=" + ability_time5 + ", ability_level5="
				+ ability_level5 + ", ability_code6=" + ability_code6 + ", ability_time6=" + ability_time6
				+ ", ability_level6=" + ability_level6 + ", ability_code7=" + ability_code7 + ", ability_time7="
				+ ability_time7 + ", ability_level7=" + ability_level7 + ", ability_code8=" + ability_code8
				+ ", ability_time8=" + ability_time8 + ", ability_level8=" + ability_level8 + ", ability_code9="
				+ ability_code9 + ", ability_time9=" + ability_time9 + ", ability_level9=" + ability_level9
				+ ", ability_code10=" + ability_code10 + ", ability_time10=" + ability_time10 + ", ability_level10="
				+ ability_level10 + ", ability_code11=" + ability_code11 + ", ability_time11=" + ability_time11
				+ ", ability_level11=" + ability_level11 + ", ability_code12=" + ability_code12 + ", ability_time12="
				+ ability_time12 + ", ability_level12=" + ability_level12 + ", ability_code13=" + ability_code13
				+ ", ability_time13=" + ability_time13 + ", ability_level13=" + ability_level13 + ", ability_code14="
				+ ability_code14 + ", ability_time14=" + ability_time14 + ", ability_level14=" + ability_level14
				+ ", ability_code15=" + ability_code15 + ", ability_time15=" + ability_time15 + ", ability_level15="
				+ ability_level15 + ", ability_code16=" + ability_code16 + ", ability_time16=" + ability_time16
				+ ", ability_level16=" + ability_level16 + ", ability_code17=" + ability_code17 + ", ability_time17="
				+ ability_time17 + ", ability_level17=" + ability_level17 + ", ability_code18=" + ability_code18
				+ ", ability_time18=" + ability_time18 + ", ability_level18=" + ability_level18 + ", ability_code19="
				+ ability_code19 + ", ability_time19=" + ability_time19 + ", ability_level19=" + ability_level19
				+ ", ability_code20=" + ability_code20 + ", ability_time20=" + ability_time20 + ", ability_level20="
				+ ability_level20 + ", ability_code21=" + ability_code21 + ", ability_time21=" + ability_time21
				+ ", ability_level21=" + ability_level21 + ", ability_code22=" + ability_code22 + ", ability_time22="
				+ ability_time22 + ", ability_level22=" + ability_level22 + ", ability_code23=" + ability_code23
				+ ", ability_time23=" + ability_time23 + ", ability_level23=" + ability_level23 + ", ability_code24="
				+ ability_code24 + ", ability_time24=" + ability_time24 + ", ability_level24=" + ability_level24
				+ ", ability_code25=" + ability_code25 + ", ability_time25=" + ability_time25 + ", ability_level25="
				+ ability_level25 + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
