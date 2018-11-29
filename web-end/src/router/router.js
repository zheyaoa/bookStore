import Vue from 'vue'
import Router from 'vue-router'
import Home from 'server/home/Home'
import Personal from 'server/personal/Personal'
import ShoppingCart from 'server/shoppingCart/ShoppingCart'
import Order from 'server/order/Order'
import Address from 'server/address/Address'
import Login from '@/components/Login'
import Register from '@/components/Register'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path:'/personal',
      name:'personal',
      component:Personal
    },
    {
      path:'/login',
      name:'Login',
      component:Login
    },
    {
      path:'/register',
      name:'Register',
      component:Register
    },
    {
      path:'/shoppingCart',
      name:'shoppingCart',
      component:ShoppingCart
    },
    {
      path:'/order',
      name:'order',
      component:Order
    }
  ]
})
