import Vue from 'vue'
import VueRouter from 'vue-router'
import Serch from '../views/serch.vue'
import MatchInf from '../views/MatchInf.vue'
import UserInfo from '../views/userInfo.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'serch',
    component: Serch
  },
  {
    path: '/loginofsteam/:steamid',
    name: 'serch',
    component: Serch
  },
  {
    path: '/matchinf',
    name: 'matchinf',
    component: MatchInf
  },{
    path:'/userinfocode/:code',
    name:'userinfo',
    component: UserInfo
  },{
    path:'/userinfo',
    name:'userinfo',
    component: UserInfo
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
