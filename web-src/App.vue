<template>
  
  <el-container>
   <el-header>
      <el-row index="1">
        <el-col :span="5" index="1-1"><div class="grid-content"></div></el-col>
        <el-col :span="14" index="1-2">
          <div class="grid-content">
            <el-row index="1-2-1">
              <el-col :span="5" index="1-2-1-1">
                <div class="grid-content" v-on:click="mainPage" style="cursor:pointer">
                  <a style="font-size: 45px; color: #fff; font-weight: bold; text-decoration:none;" >DOTA2</a>
                </div>
                </el-col>
              <el-col :span="10" index="1-2-1-2">
                <div class="grid-content">
                </div>
              </el-col>
              <el-col :span="7" index="1-2-1-3">
                <div class="grid-content">
                  
                </div>
              </el-col>
              <el-col :span="1">
                  <div  v-if="notLogin" @click="loginDialogVisible = true" class="login">
                    <font color="#fff" size="2">登录</font>
                  </div>
                  <div v-else>
                      <img v-on:click="userInfo" class="getgold_top_head_img_face" :src="imgUrl"/>
                  </div>
                  <!-----------------------------------登录框-------------------------------------------------->
                  <el-dialog title="登录" :visible.sync="loginDialogVisible" width="20%" center>
                    <font v-if="accounOrPasswordError" color="red">账号或密码错误！</font>
                    <font v-if="networkError"  color="red">网络状况不良，请重试</font>
                    <font v-if="accountIllegal" color="red">输入含有非法字符！！</font>
                     <font v-if="accountTooShort" color="red">账号至少6位</font>
                    <el-input placeholder="请输入账号" prefix-icon="el-icon-user-solid" v-model="userAccount" maxlength="30" ></el-input>
                    <font v-if="accountEmpty" color="red">不能为空！</font>
                    <div class="gap"></div>
                    <el-input placeholder="请输入密码"  prefix-icon="el-icon-s-goods" v-model="userPassword"  maxlength="20" show-password></el-input>
                    <font v-if="passwordTooShort" color="red">密码至少9位</font>
                    <font v-if="passwordEmpty" color="red">不能为空！</font>
                     <font v-if="passwordIllegal" color="red">输入含有非法字符！！</font>
                    <div class="gap"></div>
                     <div class="captCharCode">
                        <el-row :gutter="8">
                          <el-col :span="12">
                            <div v-on:keyup.enter="postUserInfo" style="min-height:60px;">
                               <el-input  placeholder="验证码"  v-model="catcharCode" maxlength="4"></el-input>
                               <font v-if="catcharCodeEmpty" color="red">不能为空！</font>
                               <font v-if="catcharCodeError" color="red">验证码错误！</font>
                               <font v-if="catcharCodeIllegal" color="red">输入含有非法字符！！</font>
                            </div>
                            </el-col>
                          <el-col :span="12">
                            <div style="min-height:60px; cursor:pointer; " v-on:click="changeCode">
                          <img  :src="url"/>
                            </div>
                            </el-col>
                        </el-row>
                        <el-checkbox v-model="checked">在此台电脑上记住我</el-checkbox>
                      </div>
                    <span slot="footer" class="dialog-footer">
                    <el-row>
                          <el-col :span="3"><div style="min-height:30px"></div></el-col>
                            <el-col :span="18"><div style="min-height:30px"><img @click="steaLogin" style="cursor:pointer" src="./assets/sits_small.png"/></div></el-col>
                            <el-col :span="3"><div style="min-height:30px"></div></el-col>
                        </el-row>
                         <div class="gap"></div>
                    <el-button  @click="loginDialogVisible = false" :disabled.sync="buttonState">取 消</el-button>
                    <el-button type="primary"  v-on:click="postUserInfo" :disabled.sync="buttonState" :loading.sync="buttonState">确 定</el-button>
                    </span>
                  </el-dialog>
                  <!-------------------------------注册框-------------------------------------------------->
                  <el-dialog title="注册" :visible.sync="resDialogVisible" width="20%" center>
                     <el-input placeholder="请输入账号" prefix-icon="el-icon-user-solid" v-model="resAccount" maxlength="30" ></el-input>
                     <font v-if="resNetworkError"  color="red">网络状况不良，请重试</font>
                      <font v-if="resAccountIllegal" color="red">输入含有非法字符！！</font>
                      <font v-if="resAccountTooShort" color="red">账号至少6位</font>
                      <font v-if="resAccountEmpty" color="red">不能为空！</font>
                      <font v-if="accountExitis" color="red">账号已经存在！</font>
                      <div class="gap"></div>
                      <el-input placeholder="请输入密码" prefix-icon="el-icon-s-goods" v-model="resPassword" maxlength="20" show-password></el-input>
                       <font v-if="resPasswordEmpty" color="red">不能为空！</font>
                        <font v-if="resPasswordIllegal" color="red">输入含有非法字符！！</font>
                        <font v-if="resPasswordTooShort" color="red">密码至少9位</font>
                      <div class="gap"></div>
                      <el-input placeholder="确认密码" prefix-icon="el-icon-s-goods" v-model="resPasswordCon" maxlength="20" show-password></el-input>
                       <font v-if="resPasswordConEmpty" color="red">不能为空！</font>
                       <font v-if="resPasswordNotEq" color="red">密码不一致！</font>
                        <font v-if="resPasswordConIllegal" color="red">输入含有非法字符！！</font>
                      <div class="gap"></div>
                      <div class="captCharCode">
                        <el-row :gutter="8">
                          <el-col :span="12">
                            <div style="min-height:60px;" v-on:keyup.enter="postResUserInfo">
                               <el-input  placeholder="验证码"  v-model="resCatcharCode" maxlength="4"></el-input>
                               <font v-if="resCatcharCodeEmpty" color="red">不能为空！</font>
                               <font v-if="resCatcharCodeError" color="red">验证码错误！</font>
                               <font v-if="resCatcharCodeIllegal" color="red">输入含有非法字符！！</font>
                            </div>
                            </el-col>
                          <el-col :span="12">
                            <div style="min-height:60px; cursor:pointer; " v-on:click="changeCode">
                          <img  :src="url"/>
                            </div>
                            </el-col>
                        </el-row>
                      </div>
                    <span slot="footer" class="dialog-footer">
                    <el-button @click="resDialogVisible = false" :disabled.sync="resButtonState">取 消</el-button>
                    <el-button type="primary" @click="postResUserInfo" :disabled.sync="resButtonState" :loading.sync="resButtonState">确 定</el-button>
                    </span>
                    </el-dialog>
                    <!-------------------------------注册end---------------------------------------------->
                    
                    <!----------------------------------注册成功提示------------------------------------------------->
                    <el-dialog title="提示" :visible.sync="resSuccessDialogVisible" width="30%" center>
                      <span>恭喜！注册成功</span>
                      <span slot="footer" class="dialog-footer">
                      <el-button @click="centerDialogVisible = false">取 消</el-button>
                      <el-button type="primary" @click="resSuccessDialogVisible = false">确 定</el-button>
                      </span>
                    </el-dialog>
                    <!----------------------------------注册成功提示End------------------------------------------------->
              </el-col>
                <el-col :span="1">
                  <div  v-if="notLogin" @click="resDialogVisible = true" class="login">
                    <font color="#fff" size="2">注册</font>
                  </div>
                  <div v-else  v-on:click="cancellation" class="login">
                     <font color="#fff" size="2">注销</font>
                  </div>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="5" index="1-3"><div class="grid-content"></div></el-col>
      </el-row>
    </el-header>



    <el-main style="padding: 0px;">
     <router-view></router-view>
     <div style=" height:100px;text-align: center;" id="icp">
       <div style="height:50px;"></div>
      <font size="3" color=" #bfbfbf"></font>
    </div>
    </el-main>

  </el-container>
    
  </template>

  
<script>
import axios from 'axios';
import Cookies from 'js-cookie'
import line from './views/line.js'
import url from '@/assets/url.json'
line;
var getUser = function(point){
    axios.post(
            'http://'+url.urlOut+'/dota2Query/getUser',
            {
              //account:'',
              //password:'',
              //catcharCode:'',
              token:Cookies.get('token')
              //acc_id:0,
              //pageNum:0
            },{
              withCredentials : true
              } 
          ).then(function (res){
            point.notLogin=false;
            point.imgUrl =  'http://'+url.urlOut+'/dota2Query/getUserImg/'+res.data.img;
          })
}
  export default{
    data(){
      return{
        //登录错误信息
        accounOrPasswordError:false,
        accountEmpty:false,
        accountIllegal:false,
        passwordEmpty:false,
        passwordIllegal:false,
        catcharCodeEmpty:false,
        catcharCodeIllegal:false,
        catcharCodeError:false,
        accountTooShort:false,
        passwordTooShort:false,
        //注册登录错误信息
        resButtonState:false,
        accountExitis:false,
        resAccountEmpty:false,
        resAccountIllegal:false,
        resPasswordEmpty:false,
        respasswordIllegal:false,
        resPasswordConEmptya:false,
        resPasswordConIllegal:false,
        resCatcharCodeEmpty:false,
        resCatcharCodeError:false,
        resCatcharCodeIllegal:false,
        resPasswordNotEq:false,
        resAccountTooShort:false,
        resPasswordTooShort:false,
        resPasswordConTooShort:false,
        resNetworkError:false,
        //end
        buttonState:false,
        loginDialogVisible: false,
        networkError:false,
        checked:false,
        notLogin: true,
        //登录信息
        userAccount:'',
        userPassword:'',
        catcharCode:'',
        //注册信息
        resAccount:'',
        resPassword:'',
        resPasswordCon:'',
        resCatcharCode:'',
        resSuccessDialogVisible:false,
        url:'http://'+url.urlOut+'/dota2Query/code',
        imgUrl:"",
        user:{},
        resDialogVisible:false,
        steamLogin:'https://steamcommunity.com/openid/login?openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.realm=http%3A%2F%2Fwww.dotainfo.xyz%2F&openid.sreg.required=nickname%2Cemail%2Cfullname&openid.assoc_handle=None&openid.return_to=http%3A%2F%2Fwww.dotainfo.xyz%2Fdota2Query%2Faccount%2Flogin%2Fsteam%2Fverification%3Fback_url%3D%252Faccount%252Fsteam_bind%252Ffinish&openid.ns.sreg=http%3A%2F%2Fopenid.net%2Fextensions%2Fsreg%2F1.1&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select'
      }
    },
    methods:{

      login:function(){  this.$router.push({path:'/login'})},
      mainPage:function(){this.$router.push({path:'/'})},
      changeCode: function(){this.url='http://'+url.urlOut+'/dota2Query/code?'+Math.random()},
      postUserInfo: function(){
        var _this = this;
         var accExp = new RegExp("^[A-Za-z0-9]+$","i");
         var passExp = new RegExp("^[A-Za-z0-9%&=?$.]+$","i");
         _this.passwordTooShort=false;
         _this.accountTooShort=false;
         _this.accountExitis=false;
        _this.accountIllegal=false;
        _this.accountEmpty=false;
        _this.passwordEmpty=false;
        _this.passwordIllegal=false;
        _this.catcharCodeEmpty=false;
        _this.catcharCodeIllegal=false;
        _this.catcharCodeError=false;
         _this.networkError=false;
        if (_this.userAccount.length!=0){//是否含有特殊符号
           if (!accExp.test(_this.userAccount)===true){
          _this.accountIllegal=true;
          }
          if (_this.userAccount.length<7){
            _this.accountTooShort=true;
          }
        }else
          _this.accountEmpty=true;

        if (_this.userPassword.length!=0){
            if (!passExp.test(_this.userPassword)===true){
            _this.passwordIllegal=true;
            }
            if (_this.userPassword.length<10){
              _this.passwordTooShort=true;
            }
        }else
          _this.passwordEmpty=true;
        
        if (_this.catcharCode!=0){
            if (!accExp.test(_this.catcharCode)===true)
            _this.catcharCodeIllegal=true;
        }else
          _this.catcharCodeEmpty=true
      
        if (!( _this.accountIllegal|| _this.accountEmpty||_this.passwordIllegal|| _this.passwordEmpty|| _this.catcharCodeIllegal||_this.catcharCodeEmpty||_this.accountTooShort||_this.passwordTooShort)){
           _this.buttonState=true;

            axios.post('http://'+url.urlOut+'/dota2Query/login',
           {
             account:this.userAccount,
             password:this.userPassword,
             catcharCode:this.catcharCode
             }, {
              withCredentials : true
          } ).then(function (res){
              if (res.data.state=="ok"){
              _this.loginDialogVisible=false;
              _this.buttonState=false;
                _this.notLogin=false;
                var inFifteenMinutes ;
                if (_this.checked){
                  inFifteenMinutes=new Date(new Date().getTime() + 7*24 * 60 * 60 * 1000);
                }
                inFifteenMinutes = new Date(new Date().getTime() + 6 * 60 * 60 * 1000);//设置默认cookie过期时间6小时
                Cookies.set('token',res.data.token,{expires:inFifteenMinutes});
                getUser(_this);
                
              }
              if (res.data.state=="Error"){
                 _this.buttonState=false;
                 if (res.data.code=="2")
                  _this.catcharCodeError=true;
                  if (res.data.code=="1")
                  _this.accounOrPasswordError=true;
              }
            }).catch(function (){
                _this.buttonState=false;
                _this.networkError=true;
            });
        }
      },postResUserInfo:function(){
         var _this = this;
         var accExp = new RegExp("^[A-Za-z0-9]+$","i");
         var passExp = new RegExp("^[A-Za-z0-9%&=?$.]+$","i");
          _this.resButtonState=true;
         //初始化
        _this.accountExitis=false;
         _this.resAccountEmpty=false;
        _this.resAccountIllegal=false;
        _this.resPasswordEmpty=false;
        _this.respasswordIllegal=false;
        _this.resPasswordConEmptya=false;
        _this.resPasswordConIllegal=false;
        _this.resCatcharCodeEmpty=false;
        _this.resCatcharCodeError=false;
        _this.resCatcharCodeIllegal=false;
        _this.resPasswordNotEq=false;
         _this.resNetworkError=false;
        if (_this.resAccount.length!=0){
          if (!accExp.test(_this.resAccount)===true)
           _this.resAccountIllegal=true;
          if (_this.resAccount.length<7)
          _this.resAccountTooShort=true;
        }else{
            _this.resAccountEmpty=true;
        }
        if (_this.resPassword.length!=0){
          if (!passExp.test(_this.resPassword)===true){
            _this.respasswordIllegal=true;
          }
          if (_this.resPassword.length<10){
            _this.resPasswordTooShort=true;
          }
        }else{
          _this.resPasswordEmpty=true;
        }
        if (_this.resPasswordCon.length!=0){
            if (!passExp.test(_this.resPasswordCon)===true){
              _this.resPasswordConIllegal=true;
            }
            if (_this.resPasswordCon.length<10){
              _this.resPasswordConTooShort=true;
            }
        }else{
          _this.resPasswordConEmpty=true;
        }
        if (_this.resCatcharCode.length!=0){
          if (!accExp.test(_this.resCatcharCode)===true){
            _this.resCatcharCodeIllegal=true;
          }
        }else{
          _this.resCatcharCodeEmpty=true;
        }
        if (!(_this.resPasswordEmpty||_this.resPasswordConEmptya)){
          if (_this.resPassword!=_this.resPasswordCon){
          _this.resPasswordNotEq = true;

          }
        }

        if(!(_this.resAccountIllegal||_this.resPasswordEmpty||_this.resPasswordConEmptya||_this.respasswordIllegal
        ||_this.resPasswordConIllegal||_this.resCatcharCodeEmpty||_this.resCatcharCodeIllegal||_this.resPasswordNotEq||_this.resAccountTooShort||_this.resPasswordTooShort)){
          
            axios.post('http://'+url.urlOut+'/dota2Query/register',
           {
             account:_this.resAccount,
             password:_this.resPassword,
             catcharCode:_this.resCatcharCode
             }, {
              withCredentials : true
          } ).then(function (res){
              if (res.data.state=="ok"){
                
              _this.resDialogVisible=false;
              _this.resButtonState=false;
                _this.notLogin=false;
                _this.resSuccessDialogVisible=true;
                var inFifteenMinutes ;
                inFifteenMinutes = new Date(new Date().getTime() + 6 * 60 * 60 * 1000);//设置默认cookie过期时间6小时
                Cookies.set('token',res.data.token,{expires:inFifteenMinutes});
                getUser(_this);
                
              }
              if (res.data.state=="Error"){
                 _this.resButtonState=false;
                 if (res.data.code=="2")
                  _this.resCatcharCodeError=true;
                  if (res.data.code=="3")
                  _this.accountExitis=true;
              }
            }).catch(function (){
                _this.resButtonState=false;
                _this.resNetworkError=true;
            });
        }
        _this.resButtonState=false;
      }
      ,cancellation:function(){
        this.accountIllegal=false;
        this.accountEmpty=false;
        this.passwordEmpty=false;
        this.passwordIllegal=false;
        this.catcharCodeEmpty=false;
        this.catcharCodeIllegal=false;
        this.networkError=false;

        this.userAccount='';
        this.userPassword='';
        this.catcharCode='';
        this.resAccount='';
        this.resPassword='';
        this.resPasswordCon='';
        this.resCatcharCode='';
        this.url='http://'+url.urlOut+'/dota2Query/code?'+Math.random();
        this.checked=false;
        Cookies.remove('token')
        this.notLogin=true;
        this.$router.push({path:'/'})
      },
      userInfo:function(){
        this.$router.push({path:'/userinfo'})
      },
      steaLogin:function(){
        window.open(this.steamLogin)
      }
    },mounted:function(){
      var _this = this;
      var dt = new Date(); 
      dt.setSeconds(dt.getSeconds() + 60); 
      document.cookie = "cookietest=1; expires=" + dt.toGMTString(); 
      var cookiesEnabled = document.cookie.indexOf("cookietest=") != -1; 
      if(!cookiesEnabled) {
        alert('没有启用cookie,无法正常登录');
      } 
      if (Cookies.get('token')!=null){
       getUser(_this,_this.user)
        return;
      }
      if (_this.$route.params.steamid!=null){
        axios.post(
            'http://'+url.urlOut+'/dota2Query/findSteamId/'+_this.$route.params.steamid,
            {account:_this.$route.params.steamid}
            ).then(
              function(res){
                if (res.data.state=="ok"){
                  Cookies.set('token',res.data.token);
                  getUser(_this,_this.user)
                    return;
                }
              }
            )
      }
    }
  }

  
</script>

<style>

    .el-header{
      height: 61px;
      background-color: #212131;
  }


.grid-content {
    min-height: 61px;
   background-color: #212131;
  }

  .el-main{
    padding: 0px;

    height: 700px;
  }

  body{
   background-image: url('08.png');
   background-color: #0c1520;
   background-repeat:no-repeat;
  }

  .el-input{
    width: 300px;
  }


  .grid-content2{
     margin-bottom: 60px;
    border-radius: 4px;
    min-height: 60px;
  }

  .login{
    cursor:pointer;
    min-height:61px;
    text-align: center;
    line-height: 60px;
  }
  .login:hover,.login:active{
    background-color:#0a0a0f
;
  }
  .gap{
     min-height:20px;
  }

html,body,#app,.el-container{
       
        padding: 0px;
        margin: 0px;
        height: 100%;
    }
.getgold_top_head_img_face{
    height: 50px;
    width: 50px;
    border-radius:50%;
    -webkit-border-radius:50%;
    -moz-border-radius:50%;
    margin-top: 5px;
     cursor:pointer;
}

  </style>