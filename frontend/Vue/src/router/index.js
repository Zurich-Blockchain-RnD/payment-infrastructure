import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/components/Welcome'
import Home from '@/components/Home'
import Register from '@/components/Register'
import Confirm from '@/components/Confirm'
import MetamaskStats from '@/components/MetamaskStats'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    },
    {
      path: '/home',
      name: Home,
      component: Home
    },
    {
      path: '/register',
      name: Register,
      component: Register
    },
    {
      path: '/confirm',
      name: Confirm,
      component: Confirm
    },
    {
      path: '/metamask',
      name: MetamaskStats,
      component: MetamaskStats
    }
  ]
})
