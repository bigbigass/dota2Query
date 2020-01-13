<template>
    <div >
         <el-row >
        <el-col :span="16"><div class="grid-content2"></div></el-col>
        <el-col :span="8"><div class="grid-content2"></div></el-col>
      </el-row>

      <el-row >
        <el-col :span="8"><div class="grid-content2"></div></el-col>
        <el-col :span="8"><div class="grid-content2"></div></el-col>
        <el-col :span="8"><div class="grid-content2"></div></el-col>
      </el-row>

      <el-row >
        <el-col :span="8"><div class="grid-content2"></div></el-col>
        <el-col :span="8">
          <div class="grid-content2" v-on:keyup.enter="submitMat">
              <el-input placeholder="请输入比赛编号" style="width: 600px;" v-model="input" clearable>
                <el-button slot="append" icon="el-icon-search" style="width:100px;" @click="submitMat"></el-button>
              </el-input>
          </div>
        </el-col>
        <el-col :span="8"><div class="grid-content2"></div></el-col>
      </el-row>
      <!---------------------------走马灯---------------------------------->
      <el-row >
        <el-col :span="6"><div style="height:450px"></div></el-col>
        <el-col :span="12">
          <div style="height:450px">
             <div style="height:450px">
          <el-carousel :interval="4000" type="card" height="300px">
          <el-carousel-item v-for="item in 6" :key="item">
            <img height="300px" v-bind:src="require('../assets/loading/'+item+'.png')"/>
          </el-carousel-item>
          </el-carousel>
        </div>
          </div></el-col>
        <el-col :span="6"><div style="height:450px"></div></el-col>
      </el-row>
      <!-------------------------------提示框------------------------------------->
       <el-dialog title="提示" :visible.sync="alterDialogVisible" width="20%" center>
          <span>{{info}}</span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="alterDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="alterDialogVisible = false">确 定</el-button>
          </span>
      </el-dialog>
    </div>
</template>

<script>
import $ from 'jquery'
/* function getMatchJson() {
         $.ajax("http://localhost:8080/dota2Query/json",
            {
                dataType:"json"
            }
         ).done(function (data){console.log('success:'+JSON.stringify(data))})
         
        }*/

  export default {
    data() {
      return {
        input: '',
        alterDialogVisible:false  ,
        info:''
      }
    },
    methods:{
      submitMat(){
        var matidExp = new RegExp("^[0-9]+$","i");
        if (this.input.length==0){
          this.info='不能为空！';
          this.alterDialogVisible=true;
        }
        else if (matidExp.test(this.input)){
          this.$router.push(
            {path:'/matchinf',
            query: {  
              matId: this.input
            }
          })
        }
        else{
          this.alterDialogVisible=true;
          this.info='含有非法字符！';
          this.input='';
        }
      }
    },mounted:function(){
            $('#icp').show();
    }
  }
</script>

<style>
.grid-content2{
     margin-bottom: 60px;
    border-radius: 4px;
    min-height: 60px;
  }
    .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
   .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
</style>