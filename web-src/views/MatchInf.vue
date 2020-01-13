<template>
<div>
    <div id="serchPage" hidden="true">
        <el-row>
                      <el-col :span="24">
                          <div class="gapm"></div>
                      </el-col>
                  </el-row>
        <el-row>
            <el-col :span="8">
                <div class="grid-content3">
                    <el-row>
                        <el-col :span="8"><div class="grid-content4"></div></el-col>
                        <el-col :span="8"> 
                              <template v-if="matchInf.radiant_win">
                                <div class="grid-content4" >
                                <font size="6" color="#66bb6a">天辉胜利</font>
                            </div>
                            </template>
                              <template v-else>
                                <div class="grid-content4" >
                                <font size="6" color="#ff4c4c">夜魇胜利</font>
                            </div>
                            </template>
                        </el-col>
                        <el-col :span="8"><div class="grid-content4"></div></el-col>
                    </el-row>
                </div>
            </el-col>

            <el-col :span="8">
                <div class="grid-content3">
                  <el-row>
                        <el-col :span="8">
                            <div class="grid-content4">
                                <font size="7" color="#66bb6a">{{matchInf.radiant_score}}</font>
                            </div>
                        </el-col>
                        <!--时间、模式、日期-->
                        <el-col :span="8">
                            <div class="grid-content4">
                                <el-row><!--模式-->
                                    <el-col  :span="24"><div class="grid-content5"><font color="#fff">{{tyinfo[matchInf.game_mode]}}</font></div></el-col>
                                </el-row>
                                <el-row><!--时间-->
                                    <el-col  :span="24"><div class="grid-content5"><font color="#fff" size="6">
                                        {{(matchInf.duration-matchInf.duration%60)/60}}:<span v-if="matchInf.duration%60<=9">0</span>{{matchInf.duration%60}}</font></div></el-col>
                                </el-row>
                                <el-row><!--日期-->
                                    <el-col  :span="24"><div class="grid-content5"><font color="#fff" size="2">{{matchDate}}</font></div></el-col>
                                </el-row>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="grid-content4">
                                 <font size="7" color="#ff4c4c">{{matchInf.dire_score}}</font>
                            </div>
                        </el-col>
                    </el-row>
                </div>
            </el-col>

            <el-col :span="8">
                <div class="grid-content3">
                    <!--编号地区-->
                    <el-row>
                        <el-col :span="5"><!--编号-->
                            <div class="grid-content4">
                                <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#bfbfbf" size="2">比赛编号</font></div></el-col>
                                </el-row>
                                 <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#fff">{{matchInf.mat_id}}</font></div></el-col>
                                </el-row>
                            </div>
                        </el-col>
                        <el-col :span="5"><!--地区-->
                            <div class="grid-content4">
                                 <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#bfbfbf" size="2">服务器</font></div></el-col>
                                </el-row>
                                 <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#fff" size="2">{{matchInf.cluster}}</font></div></el-col>
                                </el-row>
                            </div>
                        </el-col>
                        <el-col :span="6"><!--水平-->
                            <div class="grid-content4">
                                 <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#bfbfbf" size="2">联赛ID</font></div></el-col>
                                </el-row>
                                 <el-row>
                                    <el-col span="24"><div class="grid-content5"><font color="#fff" >{{matchInf.leagueid}}</font></div></el-col>
                                </el-row>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="grid-content4"></div>
                        </el-col>
                    </el-row>
                </div>
            </el-col>
        </el-row>

        <!--<el-row>
            <el-col :span="8">
                <div class="grid-content6"></div>
            </el-col>

            <el-col :span="8">
                <div class="grid-content6"></div>
            </el-col>

            <el-col :span="8">
                <div class="grid-content6"></div>
            </el-col>
        </el-row>-->
        <!--主要数据组件-->
        
        <el-row>
            <el-col :span="3">
                <div class="grid-contentMains"></div>
            </el-col>
            <el-col :span="18">
                <div class="grid-contentMain" >
                    <img src="../assets/radiant_png.png" width="20px" height="20px"/>
                    <font size="5" color="#cccccc">天辉</font>
                  <el-row>
                      <el-col :span="24">
                          <div class="gapT">
                           
                          </div>
                      </el-col>
                  </el-row>
                  <!--以下是表格头-->
                    <el-table :data="teamTianhui" :row-style="{background: '#47476b',color: ' #d9d9d9'   }"
    :header-cell-style="{background: '#28283e',color: ' #d9d9d9'}" style="width: 100%;" >
                        <el-table-column label="英雄" width="70">
                       <template slot-scope="scope">
                                <img v-on:mouseenter="heroInfo" v-on:mouseleave="hiddinHeroInfo" v-bind:src="require('../assets/hero_sb/'+scope.row.face+'_sb.png')"/>
                                </template>
                        </el-table-column>
                       <el-table-column prop="player" label="玩家" width="99"><template slot-scope="scope"><font color=" #4da6ff" >{{scope.row.player}}</font></template></el-table-column>
                         <el-table-column prop="level" label="等级" width="60"></el-table-column>
                          <el-table-column prop="kill" label="击杀" width="60"><template slot-scope="scope"><font color="#76ad79">{{scope.row.kill}}</font></template></el-table-column>
                           <el-table-column prop="deaths" label="死亡" width="60"><template slot-scope="scope"><font color="#ed5e5e">{{scope.row.deaths}}</font></template></el-table-column>
                            <el-table-column prop="ass" label="助攻" width="60"><template slot-scope="scope"><font color="#7c99a8">{{scope.row.ass}}</font></template></el-table-column>
                             <el-table-column prop="hits" label="正补" width="60"></el-table-column>
                              <el-table-column prop="denies" label="反补" width="60"></el-table-column>
                               <el-table-column prop="gpm" label="GPM" width="60"><template slot-scope="scope"><font color="#ffd633">{{scope.row.gpm}}</font></template></el-table-column>
                                <el-table-column prop="xpm" label="XPM" width="60"></el-table-column>
                                 <el-table-column prop="hdm" label="英雄伤害" width="60"></el-table-column>
                                  <el-table-column prop="tdm" label="建筑伤害" width="60"></el-table-column>
                                   <el-table-column prop="hhl" label="英雄治疗" width="60"></el-table-column>
                                    <el-table-column prop="gold" label="经济" width="60"><template slot-scope="scope"><font color="#ffd633">{{scope.row.gold}}</font></template></el-table-column>
                                    <el-table-column prop="i0" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i0+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i1" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i1+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i2" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i2+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i3" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i3+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i4" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i4+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i5" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i5+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b0" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac0+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b1" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac1+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b2" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac2+'.png')"/></template></el-table-column>
                                       <el-table-column prop="b3" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac3+'.png')"/></template></el-table-column>
                    </el-table>
                   <el-row>
                      <el-col :span="24">
                          <div class="gapm">
                          </div>
                      </el-col>
                  </el-row>
                  <img src="../assets/dire_png.png" width="20px" height="20px"/>
                     <font size="5" color="#cccccc">夜魇</font>
                  <el-row>
                      <el-col :span="24">
                          <div class="gapY">
                          </div>
                      </el-col>
                  </el-row>
                   <!--以下是表格头-->
                    <el-table :data="teamYeyan" :row-style="{background: '#47476b',color: ' #d9d9d9'}"
    :header-cell-style="{background: '#28283e',color: '#d9d9d9'}" style="width: 100%">
                        <el-table-column prop="face" label="英雄" width="70">
                            <template slot-scope="scope">
                                <img v-on:mouseenter="heroInfo" v-on:mouseleave="hiddinHeroInfo" v-bind:src="require('../assets/hero_sb/'+scope.row.face+'_sb.png')"/>
                                </template>
                        </el-table-column>
                        <el-table-column prop="player" label="玩家" width="99"><template slot-scope="scope"><font color=" #4da6ff">{{scope.row.player}}</font></template></el-table-column>
                         <el-table-column prop="level" label="等级" width="60"></el-table-column>
                          <el-table-column prop="kill" label="击杀" width="60"><template slot-scope="scope"><font color="#76ad79">{{scope.row.kill}}</font></template></el-table-column>
                           <el-table-column prop="deaths" label="死亡" width="60"><template slot-scope="scope"><font color="#ed5e5e">{{scope.row.deaths}}</font></template></el-table-column>
                            <el-table-column prop="ass" label="助攻" width="60"><template slot-scope="scope"><font color="#7c99a8">{{scope.row.ass}}</font></template></el-table-column>
                             <el-table-column prop="hits" label="正补" width="60"></el-table-column>
                              <el-table-column prop="denies" label="反补" width="60"></el-table-column>
                               <el-table-column prop="gpm" label="GPM" width="60"><template slot-scope="scope"><font color="#ffd633">{{scope.row.gpm}}</font></template></el-table-column>
                                <el-table-column prop="xpm" label="XPM" width="60"></el-table-column>
                                 <el-table-column prop="hdm" label="英雄伤害" width="60"></el-table-column>
                                  <el-table-column prop="tdm" label="建筑伤害" width="60"></el-table-column>
                                   <el-table-column prop="hhl" label="英雄治疗" width="60"></el-table-column>
                                    <el-table-column prop="gold" label="经济" width="60"><template slot-scope="scope"><font color="#ffd633">{{scope.row.gold}}</font></template></el-table-column>
                                    <el-table-column prop="i0" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i0+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i1" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i1+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i2" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i2+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i3" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i3+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i4" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i4+'.png')"/></template></el-table-column>
                                     <el-table-column prop="i5" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.i5+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b0" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac0+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b1" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac1+'.png')"/></template></el-table-column>
                                      <el-table-column prop="b2" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac2+'.png')"/></template></el-table-column>
                                       <el-table-column prop="b3" label="" width="54"><template slot-scope="scope"><img width="54" height="40"  v-bind:src="require('../assets/item/'+scope.row.bac3+'.png')"/></template></el-table-column>
                    </el-table>
                  <el-row>
                      <el-col :span="24">
                          <div class="gapm"></div>
                      </el-col>
                  </el-row>
                  <!--下面是加点表-->
                  <img src="../assets/radiant_png.png" width="20px" height="20px"/>
                       <font size="5" color="#cccccc">天辉技能加点</font>
                <el-row>
                      <el-col :span="24">
                          <div class="gapT">
                          </div>
                      </el-col>
                  </el-row>
                 
                  <!--表格测试-->
                  <el-table :data="ability_table_of_tianhui"  :row-style="{background: '#47476b',color: ' #d9d9d9'}"
    :header-cell-style="{background: '#28283e',color: ' #d9d9d9'}" width='100%'>
                       <el-table-column label="英雄" width="70">
                          <template slot-scope="scope">
                                <img v-bind:src="require('../assets/hero_sb/'+scope.row.face+'_sb.png')"/>
                                </template>
                           </el-table-column>
                      <el-table-column prop="name" label="玩家" width="109"><template slot-scope="scope"><font color=" #4da6ff">{{scope.row.name}}</font></template></el-table-column>
                      <el-table-column prop="ab1" label="1" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab1)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab1_time-(scope.row.ab1_time%60))/60+":"+scope.row.ab1_time%60}}</div></template>
                      </el-table-column>
                     <el-table-column prop="ab2" label="2" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab2)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab2_time-(scope.row.ab2_time%60))/60+":"+scope.row.ab2_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab3" label="3" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab3)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab3_time-(scope.row.ab3_time%60))/60+":"+scope.row.ab3_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab4" label="4" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab4)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab4_time-(scope.row.ab4_time%60))/60+":"+scope.row.ab4_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab5" label="5" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab5)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab5_time-(scope.row.ab5_time%60))/60+":"+scope.row.ab5_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab6" label="6" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab6)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab6_time-(scope.row.ab6_time%60))/60+":"+scope.row.ab6_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab7" label="7" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab7)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab7_time-(scope.row.ab7_time%60))/60+":"+scope.row.ab7_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab8" label="8" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab8)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab8_time-(scope.row.ab8_time%60))/60+":"+scope.row.ab8_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab9" label="9" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab9)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab9_time-(scope.row.ab9_time%60))/60+":"+scope.row.ab9_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab10" label="10" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab10)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab10_time-(scope.row.ab10_time%60))/60+":"+scope.row.ab10_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab11" label="11" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab11)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab11_time-(scope.row.ab11_time%60))/60+":"+scope.row.ab11_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab12" label="12" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab12)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab12_time-(scope.row.ab12_time%60))/60+":"+scope.row.ab12_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab13" label="13" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab13)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab13_time-(scope.row.ab13_time%60))/60+":"+scope.row.ab13_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab14" label="14" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab14)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab14_time-(scope.row.ab14_time%60))/60+":"+scope.row.ab14_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab15" label="15" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab15)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab15_time-(scope.row.ab15_time%60))/60+":"+scope.row.ab15_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab16" label="16" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab16)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab16_time-(scope.row.ab16_time%60))/60+":"+scope.row.ab16_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab17" label="17" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab17)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab17_time-(scope.row.ab17_time%60))/60+":"+scope.row.ab17_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab18" label="18" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab18)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab18_time-(scope.row.ab18_time%60))/60+":"+scope.row.ab18_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab19" label="19" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab19)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab19_time-(scope.row.ab19_time%60))/60+":"+scope.row.ab19_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab20" label="20" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab20)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab20_time-(scope.row.ab20_time%60))/60+":"+scope.row.ab20_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab21" label="21" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab21)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab21_time-(scope.row.ab21_time%60))/60+":"+scope.row.ab21_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab22" label="22" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab22)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab22_time-(scope.row.ab22_time%60))/60+":"+scope.row.ab22_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab23" label="23" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab23)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab23_time-(scope.row.ab23_time%60))/60+":"+scope.row.ab23_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab24" label="24" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab24)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab24_time-(scope.row.ab24_time%60))/60+":"+scope.row.ab24_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab25" label="25" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab25)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab25_time-(scope.row.ab25_time%60))/60+":"+scope.row.ab25_time%60}}</div></template>
                        </el-table-column>
                  </el-table>
                  <el-row>
                      <el-col :span="24">
                          <div class="gapm"></div>
                      </el-col>
                       <img src="../assets/dire_png.png" width="20px" height="20px"/>
                   <font size="5" color="#cccccc">夜魇技能加点</font>
                  </el-row>
                  <el-row>
                      <el-col :span="24">
                          <div class="gapY">
                          </div>
                      </el-col>
                  </el-row>
                  <el-table :data=" ability_table_of_yeyan"  :row-style="{background: '#47476b',color: ' #d9d9d9'}"
    :header-cell-style="{background: '#28283e',color: ' #d9d9d9'}" width='100%' >
                      <el-table-column label="英雄" width="70">
                          <template slot-scope="scope">
                                <img v-bind:src="require('../assets/hero_sb/'+scope.row.face+'_sb.png')"/>
                                </template>
                           </el-table-column>
                      <el-table-column prop="name" label="玩家" width="109"><template slot-scope="scope"><font color=" #4da6ff">{{scope.row.name}}</font></template></el-table-column>
                      <el-table-column prop="ab1" label="1" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab1)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab1_time-(scope.row.ab1_time%60))/60+":"+scope.row.ab1_time%60}}</div></template>
                      </el-table-column>
                     <el-table-column prop="ab2" label="2" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab2)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab2_time-(scope.row.ab2_time%60))/60+":"+scope.row.ab2_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab3" label="3" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab3)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab3_time-(scope.row.ab3_time%60))/60+":"+scope.row.ab3_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab4" label="4" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab4)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab4_time-(scope.row.ab4_time%60))/60+":"+scope.row.ab4_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab5" label="5" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab5)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab5_time-(scope.row.ab5_time%60))/60+":"+scope.row.ab5_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab6" label="6" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab6)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab6_time-(scope.row.ab6_time%60))/60+":"+scope.row.ab6_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab7" label="7" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab7)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab7_time-(scope.row.ab7_time%60))/60+":"+scope.row.ab7_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab8" label="8" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab8)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab8_time-(scope.row.ab8_time%60))/60+":"+scope.row.ab8_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab9" label="9" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab9)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab9_time-(scope.row.ab9_time%60))/60+":"+scope.row.ab9_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab10" label="10" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab10)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab10_time-(scope.row.ab10_time%60))/60+":"+scope.row.ab10_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab11" label="11" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab11)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab11_time-(scope.row.ab11_time%60))/60+":"+scope.row.ab11_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab12" label="12" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab12)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab12_time-(scope.row.ab12_time%60))/60+":"+scope.row.ab12_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab13" label="13" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab13)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab13_time-(scope.row.ab13_time%60))/60+":"+scope.row.ab13_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab14" label="14" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab14)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab14_time-(scope.row.ab14_time%60))/60+":"+scope.row.ab14_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab15" label="15" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab15)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab15_time-(scope.row.ab15_time%60))/60+":"+scope.row.ab15_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab16" label="16" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab16)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab16_time-(scope.row.ab16_time%60))/60+":"+scope.row.ab16_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab17" label="17" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab17)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab17_time-(scope.row.ab17_time%60))/60+":"+scope.row.ab17_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab18" label="18" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab18)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab18_time-(scope.row.ab18_time%60))/60+":"+scope.row.ab18_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab19" label="19" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab19)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab19_time-(scope.row.ab19_time%60))/60+":"+scope.row.ab19_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab20" label="20" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab20)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab20_time-(scope.row.ab20_time%60))/60+":"+scope.row.ab20_time%60}}</div></template>
                        </el-table-column>
                          <el-table-column prop="ab21" label="21" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab21)"/>
                          <div style="position:absolute;left:0;top:0;">{{(scope.row.ab21_time-(scope.row.ab21_time%60))/60+":"+scope.row.ab21_time%60}}</div></template>
                          </el-table-column>
                     <el-table-column prop="ab22" label="22" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab22)"/>
                     <div style="position:absolute;left:0;top:0;">{{(scope.row.ab22_time-(scope.row.ab22_time%60))/60+":"+scope.row.ab22_time%60}}</div></template>
                     </el-table-column>
                      <el-table-column prop="ab23" label="23" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab23)"/>
                      <div style="position:absolute;left:0;top:0;">{{(scope.row.ab23_time-(scope.row.ab23_time%60))/60+":"+scope.row.ab23_time%60}}</div></template>
                      </el-table-column>
                       <el-table-column prop="ab24" label="24" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab24)"/>
                       <div style="position:absolute;left:0;top:0;">{{(scope.row.ab24_time-(scope.row.ab24_time%60))/60+":"+scope.row.ab24_time%60}}</div></template>
                       </el-table-column>
                        <el-table-column prop="ab25" label="25" width="50"><template slot-scope="scope"><img width="50" height="48"  v-bind:src="require('../assets/abilities/'+scope.row.ab25)"/>
                        <div style="position:absolute;left:0;top:0;">{{(scope.row.ab25_time-(scope.row.ab25_time%60))/60+":"+scope.row.ab25_time%60}}</div></template>
                        </el-table-column>
                  </el-table>
                </div>
            </el-col>
            <el-col :span="3">
                <div class="grid-contentMains"></div>
            </el-col>
        </el-row>
        <!--------------------------英雄卡片-------------------->
        <div style="width:235px;hight:200px;" id="card0" hidden="true" >
     <el-card :body-style="{ padding: '0px' }">
      <img src="/hero_vert/10_vert.jpg" style="width: 235px;hight:272px;display: block;">
      <div style="padding: 14px;background:#000d1a;text-align:center" >
        <font color="#fff" ></font>
      </div>
    </el-card>
    </div>
    </div>
    <!----------------------------------提示框-------------------------------------------->
    <el-dialog title="提示" :visible.sync="alterDialogVisible" width="20%" center>
          <span>{{info}}</span>
          <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="backSerch">确 定</el-button>
          </span>
      </el-dialog>
      <div id="loading" class="loding">
        <el-row :gutter="8"><div style="min-height:225px;text-align: center;">
            <div style="height:200px" ></div>
            <font size="8" color="#fff">Loading. . .</font>
        </div></el-row>
          <el-row :gutter="8">
              <el-col :span="8"><div style="min-height:400px;"></div></el-col>
               <el-col :span="2"><div  name="bar0" style="height:50px;background:#fff;animation:mymove 1.5s infinite;animation-delay:0s;"></div></el-col>
               <el-col :span="2"><div name="bar1" style="height:50px;background:#fff;animation:mymove 1.5s infinite;animation-delay:0.1s;"></div></el-col>
               <el-col :span="2"><div name="bar2" style="height:50px;background:#fff;animation:mymove 1.5s infinite;animation-delay:0.2s;"></div></el-col>
               <el-col :span="2"><div name="bar3" style="height:50px;background:#fff;animation:mymove 1.5s infinite;animation-delay:0.3s;"></div></el-col>
                <el-col :span="8"><div style="min-height:400px;"></div></el-col>
          </el-row>
            <el-row :gutter="8"><div style="min-height:225px;"></div></el-row>
      </div>
</div>
</template>

<script>
import $ from 'jquery'
import tree from '@/assets/tree.json'
import tyinfo from '@/assets/tyinfo.json'
import hero from '@/assets/hero.json'
import url from '@/assets/url.json'
  Date.prototype.Format = function (fmt) {
    var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + ""));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


    
    export default{

        data(){
           
            
            return{
                matchDate:{},
               tyinfo:tyinfo,
                teamTianhui:[],
                matchInf:{},
                teamYeyan:[],
                ability_table_of_tianhui:[],
                ability_table_of_yeyan:[],
                cardId:'',
                info:'',
                alterDialogVisible:false,
                show:true
            }
        },mounted: function(){
            var _this = this;
                  $('#icp').hide();
             $.ajax('http://'+url.urlOut+'/dota2Query/json?matId='+this.$route.query.matId,
            {
                dataType:"json"
            }).done(function (data){
                
                var ability_codel = new Array(25).fill("0.png");
                var userName;
                _this.matchInf=data;
                _this.matchDate = new Date(data.start*1000).Format('yy-MM-dd hh:mm:ss');
                
                for (var i = 0; i< 10; i++){
                    for (var o = 0;o<data.users.length;o++){
                        if (data.user_mats[i].acc_id==data.users[o].dota2_acc_id){
                            userName=data.users[o].steam_name;
                        }
                        if (data.user_mats[i].acc_id==4294967295)
                        userName='匿名用户'
                    }

                    for (var x = 1; x <=25;x++){
                       if (tree[data.user_mats[i]["ability_code"+x]]===undefined){
                        ability_codel[x-1]=data.user_mats[i]["ability_code"+x]+'.png';
                        }else{
                         ability_codel[x-1]="talent_tree.svg"
                          } 
                     
                    }

                    if (i<5){
                        _this. ability_table_of_tianhui.push({
                        face:data.user_mats[i].hero_id,
                        name:userName,
                        ab1:ability_codel[0],
                        ab1_time:data.user_mats[i].ability_time1,
                        ab2:ability_codel[1],
                         ab2_time:data.user_mats[i].ability_time2,
                        ab3:ability_codel[2],
                         ab3_time:data.user_mats[i].ability_time3,
                        ab4:ability_codel[3],
                         ab4_time:data.user_mats[i].ability_time4,
                        ab5:ability_codel[4],
                         ab5_time:data.user_mats[i].ability_time5,
                        ab6:ability_codel[5],
                         ab6_time:data.user_mats[i].ability_time6,
                        ab7:ability_codel[6],
                         ab7_time:data.user_mats[i].ability_time7,
                        ab8:ability_codel[7],
                         ab8_time:data.user_mats[i].ability_time8,
                        ab9:ability_codel[8],
                         ab9_time:data.user_mats[i].ability_time9,
                        ab10:ability_codel[9],
                         ab10_time:data.user_mats[i].ability_time10,
                        ab11:ability_codel[10],
                         ab11_time:data.user_mats[i].ability_time11,
                        ab12:ability_codel[11],
                         ab12_time:data.user_mats[i].ability_time12,
                        ab13:ability_codel[12],
                         ab13_time:data.user_mats[i].ability_time13,
                        ab14:ability_codel[13],
                         ab14_time:data.user_mats[i].ability_time14,
                        ab15:ability_codel[14],
                         ab15_time:data.user_mats[i].ability_time15,
                        ab16:ability_codel[15],
                         ab16_time:data.user_mats[i].ability_time16,
                        ab17:ability_codel[16],
                         ab17_time:data.user_mats[i].ability_time17,
                        ab18:ability_codel[17],
                         ab18_time:data.user_mats[i].ability_time18,
                        ab19:ability_codel[18],
                         ab19_time:data.user_mats[i].ability_time19,
                        ab20:ability_codel[19],
                         ab20_time:data.user_mats[i].ability_time20,
                        ab21:ability_codel[20],
                         ab21_time:data.user_mats[i].ability_time21,
                        ab22:ability_codel[21],
                         ab22_time:data.user_mats[i].ability_time22,
                        ab23:ability_codel[22],
                         ab23_time:data.user_mats[i].ability_time23,
                        ab24:ability_codel[23],
                         ab24_time:data.user_mats[i].ability_time24,
                        ab25:ability_codel[24],
                         ab25_time:data.user_mats[i].ability_time25
                        });

                        _this.teamTianhui.push(
                            {
                            face:data.user_mats[i].hero_id,
                            player:userName,
                            level:data.user_mats[i].level,
                            kill:data.user_mats[i].kill_num,
                            deaths:data.user_mats[i].deaths,
                            ass:data.user_mats[i].assists,
                            hits:data.user_mats[i].last_hit,
                            denies:data.user_mats[i].denis,
                            gpm:data.user_mats[i].gpm,
                            xpm:data.user_mats[i].xpm,
                            hdm:data.user_mats[i].hero_damage,
                            tdm:data.user_mats[i].tower_damage,
                            hhl:data.user_mats[i].hero_healing,
                            gold:data.user_mats[i].gold_spent,
                            i0:data.user_mats[i].item0,
                            i1:data.user_mats[i].item1,
                            i2:data.user_mats[i].item2,
                            i3:data.user_mats[i].item3,
                            i4:data.user_mats[i].item4,
                            i5:data.user_mats[i].item5,
                            bac0:data.user_mats[i].bac0,
                            bac1:data.user_mats[i].bac1,
                            bac2:data.user_mats[i].bac2,
                            bac3:data.user_mats[i].bac3}
                        )
                    }else{
                      _this. ability_table_of_yeyan.push({
                        face:data.user_mats[i].hero_id,
                        name:userName,
                        ab1:ability_codel[0],
                        ab1_time:data.user_mats[i].ability_time1,
                        ab2:ability_codel[1],
                         ab2_time:data.user_mats[i].ability_time2,
                        ab3:ability_codel[2],
                         ab3_time:data.user_mats[i].ability_time3,
                        ab4:ability_codel[3],
                         ab4_time:data.user_mats[i].ability_time4,
                        ab5:ability_codel[4],
                         ab5_time:data.user_mats[i].ability_time5,
                        ab6:ability_codel[5],
                         ab6_time:data.user_mats[i].ability_time6,
                        ab7:ability_codel[6],
                         ab7_time:data.user_mats[i].ability_time7,
                        ab8:ability_codel[7],
                         ab8_time:data.user_mats[i].ability_time8,
                        ab9:ability_codel[8],
                         ab9_time:data.user_mats[i].ability_time9,
                        ab10:ability_codel[9],
                         ab10_time:data.user_mats[i].ability_time10,
                        ab11:ability_codel[10],
                         ab11_time:data.user_mats[i].ability_time11,
                        ab12:ability_codel[11],
                         ab12_time:data.user_mats[i].ability_time12,
                        ab13:ability_codel[12],
                         ab13_time:data.user_mats[i].ability_time13,
                        ab14:ability_codel[13],
                         ab14_time:data.user_mats[i].ability_time14,
                        ab15:ability_codel[14],
                         ab15_time:data.user_mats[i].ability_time15,
                        ab16:ability_codel[15],
                         ab16_time:data.user_mats[i].ability_time16,
                        ab17:ability_codel[16],
                         ab17_time:data.user_mats[i].ability_time17,
                        ab18:ability_codel[17],
                         ab18_time:data.user_mats[i].ability_time18,
                        ab19:ability_codel[18],
                         ab19_time:data.user_mats[i].ability_time19,
                        ab20:ability_codel[19],
                         ab20_time:data.user_mats[i].ability_time20,
                        ab21:ability_codel[20],
                         ab21_time:data.user_mats[i].ability_time21,
                        ab22:ability_codel[21],
                         ab22_time:data.user_mats[i].ability_time22,
                        ab23:ability_codel[22],
                         ab23_time:data.user_mats[i].ability_time23,
                        ab24:ability_codel[23],
                         ab24_time:data.user_mats[i].ability_time24,
                        ab25:ability_codel[24],
                         ab25_time:data.user_mats[i].ability_time25
                        });
                        _this.teamYeyan.push(
                            {
                                 face:data.user_mats[i].hero_id,
                                 player:userName,
                            level:data.user_mats[i].level,
                            kill:data.user_mats[i].kill_num,
                            deaths:data.user_mats[i].deaths,
                            ass:data.user_mats[i].assists,
                            hits:data.user_mats[i].last_hit,
                            denies:data.user_mats[i].denis,
                            gpm:data.user_mats[i].gpm,
                            xpm:data.user_mats[i].xpm,
                            hdm:data.user_mats[i].hero_damage,
                            tdm:data.user_mats[i].tower_damage,
                            hhl:data.user_mats[i].hero_healing,
                            gold:data.user_mats[i].gold_spent,
                            i0:data.user_mats[i].item0,
                            i1:data.user_mats[i].item1,
                            i2:data.user_mats[i].item2,
                            i3:data.user_mats[i].item3,
                            i4:data.user_mats[i].item4,
                            i5:data.user_mats[i].item5,
                            bac0:data.user_mats[i].bac0,
                            bac1:data.user_mats[i].bac1,
                            bac2:data.user_mats[i].bac2,
                            bac3:data.user_mats[i].bac3}
                        )
                    }
                }
                $('#loading').hide();
                $('#serchPage').show();
            }
            ).catch(function(){
                _this.alterDialogVisible=true;
                _this.info='没有找到比赛！';
            });
        },methods:{
            heroInfo:function(e){
                var link =$(e.target)[0].currentSrc;
                var imgNum=link.substring(link.indexOf('/img/')+5,link.indexOf('_sb'));
              
                if ($('#card'+imgNum).length===0){
                    $('body').append($('#card0').clone(true).attr("id","card"+imgNum));
                    $('#card'+imgNum).attr("style","width: 235px;hight:272px;display: block; position:absolute;left:"+e.pageX+"px;top:"+e.pageY+"px;z-index:9999;");
                    $('#card'+imgNum+' > div > div > div >font').text(hero[imgNum])
                   
                   $('#card'+imgNum).show();
                 $('#card'+imgNum+' > div > div > img').attr("src", "/hero_vert/"+imgNum+"_vert.jpg");
             
                 
              
                   
                }else{
                     $('#card'+imgNum).attr("style","width: 235px;hight:272px;display: block; position:absolute;left:"+e.pageX+"px;top:"+e.pageY+"px;z-index:9999;")
                   $('#card'+imgNum).show();
                }
                },
                hiddinHeroInfo:function(e){
                    var link =$(e.target)[0].currentSrc;
                     var imgNum=link.substring(link.indexOf('/img/')+5,link.indexOf('_sb'));
                     if ($('#card'+imgNum).length!=0){
                         $('#card'+imgNum).hide();
                         
                     }
                },backSerch:function(){
                     var _this = this;
                    _this.alterDialogVisible=false;
                    
                      _this.$router.push({path:'/'})
                }
        }
    }
</script>

<style>
    .grid-content3{
         background: #32324d;
         min-height: 100px;
         
    }
      .grid-content6{
         background: #32324d;
         min-height: 70px;
    
    }
    .grid-content4{
       background: #32324d;
       text-align:center;
        min-height: 59px;
    }

    .grid-content5{
         background: #32324d;
        min-height: 30px;
    }

    .grid-contentMain{
        background: #32324d;
         min-height: 2100px;
    }
    .grid-contentMains{
         background: #32324d;
         min-height: 2100px;
    }
    .gapY{
         background: linear-gradient(70deg, #ff3c3c, #32324d);
         opacity:0.7;
        min-height: 10px;
    }
    .gapT{
       background: linear-gradient(70deg, #66bb6a, #32324d);
        opacity:0.7;
        min-height: 10px;
    }
    .tablehead{
        background-color:#32324d;
        min-height: 50px;
        text-align: center;
        border-bottom: 1px solid #CCCCCC;
    }
    .table{
         background-color:#32324d;
        min-height: 50px;
        text-align: center;
      
    }
    .gapm{
         background-color: #32324d;
        min-height: 50px;
    }
    
    .el-table__body-wrapper,.el-table__header-wrapper{
      background-color: #32324d;
    }

.el-table th.is-leaf, .el-table td {
    border-bottom: 1px solid  #666666!important
}
.el-table::before{
    background-color:  #666666!important;
}
    .loding{
        position:absolute;
        left:0;top:0;
        width:100%;
        height:100%;
        background:black;
        opacity:0.7;
    }
   

@keyframes mymove
{
0%   {  height: 50px;}
50%   {  height: 400px;}
100% { height: 50px;}
}
 
.el-table tbody tr:hover>td { 
    background-color:#75808bb4!important
}
.el-table  tbody  td{
    padding: 3px 0;
}
.el-table  tbody  .cell{
    padding-left: 3px;
    padding-right: 3px;
}

  

</style>