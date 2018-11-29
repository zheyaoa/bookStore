import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'style/el-reset.css';
import 'style/reset.css';
import '@/assets/iconfont/iconfont.css'
import App from './App.vue'
import router from './router/router.js'
import store from './store/store.js'
Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
