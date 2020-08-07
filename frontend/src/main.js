import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import cookies from 'vue-cookies'
import vuex from 'vuex'

import * as VueGL from 'vue-gl'
import vuetify from './plugins/vuetify'

Vue.config.productionTip = false

Vue.use(cookies)
Vue.use(vuex)

Object.keys(VueGL).forEach(name => {
  Vue.component(name, VueGL[name])
})

function init () {
  const savedToken = cookies.get('accessToken')

  if (savedToken) {
    return store.dispatch('loginByToken', savedToken)
  } else {
    return Promise.resolve()
  }
}

init().then(() => {
  new Vue({
    router,
    store,
    vuetify,
    render: h => h(App)
  }).$mount('#app')
})
