<template>
    <div>
        <!------------------资料行--------------------------->
        <el-row >
            <el-col :span="3"><div class="card"></div></el-col>
              <el-col :span="3">

                  <div class="card">
                       <div style="height:30px"></div>
                       <img class="getgold_top_head_img" :src="imgUrl"/>
                       <div style="height:50px"></div>
                       <font color=" #d9d9d9">最近比赛</font>
                  </div>
                  </el-col>
                  <!------------------name------------------------->
                  <el-col :span="3">
                      <el-row :gutter="3"> 
                          <div class="minCard" style="text-align: center;">
                            <div style="height:70px"></div>
                            <font color="#d9d9d9" size="6">{{user.steam_name}}</font>
                            </div>
                      </el-row>
                      <!-----------胜率------------------>
                      <el-row >
                          <!-----------胜-------------->
                          <el-col :span="12">
                               <div class="minCard">
                                   <div style="height:20px"></div>
                                   <font color="#999999" size="4">胜</font>
                                   <div style="height:10px"></div>
                                   <font color="#66bb6a" size="5">{{user.win}}</font>
                               </div>
                            </el-col>
                            <!----------负------------>
                           <el-col :span="12">
                                <div class="minCard">
                                    <div style="height:20px"></div>
                                   <font color="#999999" size="4">负</font>
                                   <div style="height:10px"></div>
                                    <font color="#ff3c3c" size="5">{{user.matNum-user.win}}</font>
                                </div>
                            </el-col>
                      </el-row>
                      
                      </el-col>
                      <!----------------------steam主页链接与胜率统计------------->
                  <el-col :span="3">
                      <el-row>
                          <el-col :span="12">
                              <!-----------------stram主页链接--------->
                              <div class="minCard">
                                  <div style="height:70px"></div>
                                  <img height="40px" src="../assets/timg.png"/>
                              </div>
                              </el-col>
                            <el-col :span="12"><div class="minCard"></div></el-col>
                      </el-row>
                      <el-row>
                          <div class="minCard">
                               <div style="height:20px"></div>
                                   <font color="#999999" size="4">总胜率</font>
                                     <div style="height:10px"></div>
                                     <font size="5" color="#fff">{{((user.win/user.matNum)*100).toFixed(1)}}%</font>
                          </div>
                      </el-row>                                                     
                    </el-col>
                  <el-col :span="3">
                      <div class="card">
                          <div style="height:50px"></div>
                          <font color="#d9d9d9">天梯胜率:</font>
                          <div style="height:20px"></div>
                          <el-progress v-if="user.loby7==0" type="circle" :percentage="0" stroke-width="10" color="#66bb6a"></el-progress>
                          <el-progress v-else type="circle" :percentage="(user.loby7win/user.loby7*100).toFixed(1)" stroke-width="10" color="#66bb6a"></el-progress>
                      </div>
                      </el-col>
               <el-col :span="3">
                   <div class="card">
                       <div style="height:50px"></div>
                          <font color="#d9d9d9">近20场天梯胜率:</font>
                          <div style="height:20px"></div>
                          <el-progress v-if="user.loby7==0" type="circle" :percentage="0" stroke-width="10" color="#66bb6a"></el-progress>
                          <el-progress v-else type="circle" :percentage="(user.dataOf20Lobby7).toFixed(0)" stroke-width="10" color="#66bb6a"></el-progress>
                   </div>
                   </el-col>
               <el-col :span="3">
                   <div class="card">
                       <div style="height:50px"></div>
                          <font color="#d9d9d9">近20场胜率:</font>
                          <div style="height:20px"></div>
                          <el-progress type="circle" :percentage="user.dataOf20" stroke-width="10" color="#66bb6a"></el-progress>
                   </div>
                   </el-col>
                <el-col :span="3"><div class="card"></div></el-col>
            </el-row>
            <!-------------------表格------------------------->
        <el-row >
           <el-col :span="3"><div class="mainCard"></div></el-col>
              <el-col :span="18">
                  <div class="mainCard">
                       <el-table v-loading="loading" element-loading-text="拼命加载中" v-if="user.isSys==2"
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.8)"
     :data="tableData"  :row-style="{background: '#47476b',color: ' #d9d9d9', border:'red'   }"
    :header-cell-style="{background: '#28283e',color: ' #d9d9d9'}" style="width: 100%" >
                            <el-table-column  prop="hero" label="英雄" width="60">
                                <template slot-scope="scope" >
                                <img v-bind:src="require('../assets/hero_sb/'+scope.row.hero+'_sb.png')" />
                                </template>
                            </el-table-column>
                            <el-table-column prop="heroName"   width="180">
                                <template slot-scope="scope">
                                    <font color=" #4da6ff">{{scope.row.heroName}}</font>
                                    <br/>
                                    <font color=" gray" size="1">{{countTime(scope.row.date)}}</font>
                                </template>
                            </el-table-column>
                            <el-table-column width="280">
                                <template slot-scope="scope">
                                    <font v-if="scope.row.isVic" color=" #66bb6a">胜利</font>
                                    <font v-else color=" #ff3c3c">失败</font>
                                    <br/>
                                    <font v-if="scope.row.lobby_type=='天梯比赛'" color="#997a00" size="1">{{scope.row.lobby_type}}</font>
                                    <font v-else color=" gray" size="1">{{scope.row.lobby_type}}</font>
                                </template>
                            </el-table-column>
                            <el-table-column prop="mode" label="模式" width="280">
                                 <template slot-scope="scope">
                                    <font color="  #d9d9d9">{{scope.row.mode}}</font>
                                    <br/>
                                    <font color="gray" size="1">{{scope.row.mat_id}}</font>
                                 </template>
                            </el-table-column>
                            <el-table-column prop="date" label="时长" width="140">
                                <template slot-scope="scope">
                                    <font color="  #d9d9d9">{{(scope.row.duration/60).toFixed(0)}}分钟</font>
                                 </template>
                            </el-table-column>
                              <el-table-column  width="140">
                                <template slot-scope="scope">
                                   <el-button size="mini" type="primary" @click="toMatch(scope.row.mat_id)">查看比赛详情</el-button>
                                 </template>
                            </el-table-column>
                             <el-table-column prop="kda" label="KDA" width="347">
                                <template slot-scope="scope">
                                    <el-row>
                                        <el-col :span="8"><div style="text-align:center">{{scope.row.k}}</div></el-col>
                                        <el-col :span="8"><div style="text-align:center">{{scope.row.d}}</div></el-col>
                                        <el-col :span="8"><div style="text-align:center">{{scope.row.a}}</div></el-col>
                                    </el-row>
                                    <el-row>
                                        <div style="background:#CCCCCC;height:7px">
                                             <el-col :span="countBar(scope.row.k,scope.row.allScore)"><div style="height:7px;background:#66bb6a"></div></el-col>
                                            <el-col :span="countBar(scope.row.d,scope.row.allScore)"><div style="height:7px;background:#ff3c3c;"></div></el-col>
                                            <el-col :span="countBar(scope.row.a,scope.row.allScore)"><div style="height:7px;background:#CCCCCC"></div></el-col>
                                        </div>
                                    </el-row>
                                </template>
                            </el-table-column>
                        </el-table>
                        <div style="text-align:center"  v-if="user.isSys==0">
                            <font size="30" color="azure">记录未同步！</font>
                            <el-button v-if="user.steam_code!=null" type="primary" @click="sysUserData">点此开始同步</el-button>
                            <el-button v-else type="primary" @click="bindsteam">绑定账号开始同步</el-button>
                        </div>
                         <div style="text-align:center"  v-if="user.isSys==1">
                            <font size="30" color="azure">记录正在同步中......</font>
                        </div>
                  </div>
                  </el-col>
                <el-col :span="3"><div class="mainCard"></div></el-col>
        </el-row>
        <el-row >
           <el-col :span="3"><div class="bottomCard"></div></el-col>
              <el-col :span="7"><div class="bottomCard"></div></el-col>
               <el-col :span="5">
                   <div class="bottomCard">
                       <el-pagination
                        @current-change="handleCurrentChange"
                        layout="prev, pager, next" :total="user.matNum" background=""></el-pagination>
                   </div>
                   </el-col>
                <el-col :span="6"><div class="bottomCard"></div></el-col>
                <el-col :span="3"><div class="bottomCard"></div></el-col>
        </el-row>

        <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
           <span>此用户已经被绑定！</span>
            <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
</el-dialog>
    </div>
</template>

<script>
import $ from 'jquery'
import tyinfo from '@/assets/tyinfo.json'
import loby from '@/assets/loby.json'
import hero from '@/assets/hero.json'
import axios from 'axios';
import Cookies from 'js-cookie'
import url from '@/assets/url.json'

var getMatchList = function(_this,val){
     axios.post(
               'http://'+url.urlOut+'/dota2Query/get_usermat_list',
                {
                    acc_id:_this.user.dota2_acc_id,
                    pageNum:val
                }).then(function (res){
                    _this.tableData=[];
                   for (var i = 0; i<res.data.length;i++){
                       _this.tableData.push(
                           {
                               hero:res.data[i].user_mats[0].hero_id,
                                heroName:hero[res.data[i].user_mats[0].hero_id],
                                date:res.data[i].start,
                                mode:tyinfo[res.data[i].game_mode],
                                duration:res.data[i].duration,
                                k:res.data[i].user_mats[0].kill_num,
                                d:res.data[i].user_mats[0].deaths,
                                a:res.data[i].user_mats[0].assists,
                                allScore: res.data[i].user_mats[0].kill_num+res.data[i].user_mats[0].deaths+res.data[i].user_mats[0].assists,
                                isVic: (res.data[i].radiant_win==0&&(res.data[i].user_mats[0].solt>100))||(res.data[i].radiant_win==1&&(res.data[i].user_mats[0].solt<100)) ? true:false,
                                mat_id:res.data[i].mat_id,
                                lobby_type:loby[res.data[i].lobby_type]
                           }
                       )
                   }
                   _this.loading=false
                })
}
export default{
    data(){
    
        return{
            user:{},
            imgUrl:'',
            tableData:[],
            loading:true,
            dialogVisible:false
        }
    },methods:{
       handleCurrentChange:function(val){
           var _this = this;
           this.loading = true;
            getMatchList(_this,val);
       },sysUserData:function(){
           var _this = this;
             _this.user.isSys = 1;
           axios.post('http://'+url.urlOut+'/dota2Query/sysuser',{acc_id:_this.user.steam_code,account:_this.user.account}
           )
       },
       countBar:function(x,y){ 
            if(((x/y-0.05).toFixed(2)*24).toFixed(0)==0&&x!=0)
                return 1;
            else
                return ((x/y-0.05).toFixed(2)*24).toFixed(0);
        },countTime:function(x){
            var t = new Date(x*1000).Format('yy-MM-dd');
           
            return t;
        },toMatch: function(mat_id){
            this.$router.push(
            {path:'/matchinf',
            query: {  
              matId: mat_id
            }
          })
        },
        bindsteam: function(){
            var _this = this;
            window.open('https://steamcommunity.com/openid/login?openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.realm=http%3A%2F%2Fwww.dotainfo.xyz%2F&openid.sreg.required=nickname%2Cemail%2Cfullname&openid.assoc_handle=None&openid.return_to=http%3A%2F%2Fwww.dotainfo.xyz%2Fdota2Query%2Faccount%2Flogin%2Fsteam%2Fbind%2F'+_this.user.account+'%3Fback_url%3D%252Faccount%252Fsteam_bind%252Ffinish&openid.ns.sreg=http%3A%2F%2Fopenid.net%2Fextensions%2Fsreg%2F1.1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select')
        }
    },mounted:
        function (){

            var _this = this;
            $('#icp').hide();
            if (Cookies.get('token')==null){
                this.$router.push({path:'/'})
            }
            if (_this.$route.params.code!=null){
               _this.$route.params.code;
                if (_this.$route.params.code==0)
                    _this.dialogVisible=true;
            }
            axios.post(
            'http://'+url.urlOut+'/dota2Query/getUser',
            {
              token:Cookies.get('token')
            },{
              withCredentials : true
              } 
          ).then(function (res){
              _this.user = res.data;
            _this.imgUrl =  'http://'+url.urlOut+'/dota2Query/getUserImg/'+res.data.img+'_full';
            if (_this.user.isSys==2)
            getMatchList(_this,1);
          })
        }
    
}
</script>

<style >
.card{
    height:300px;
    background: #32324d;
}
.mainCard{
    height:600px;
    background: #32324d;
}
.minCard{
    height:150px;
    background: #32324d;
}
.getgold_top_head_img{
    height: 184px;
    width: 184px;
    border-radius:50%;
    -webkit-border-radius:50%;
    -moz-border-radius:50%;
    margin-top: 5px;
}
.bottomCard{
    height:100px;
    background: #32324d;
}
  .el-table__body-wrapper,.el-table__header-wrapper{
      background-color: #32324d;
    }
    .el-table::before{
    background-color:  #666666!important;
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
.el-progress__text {
        font-size: 20px!important;
    color:azure!important
}
   
</style>