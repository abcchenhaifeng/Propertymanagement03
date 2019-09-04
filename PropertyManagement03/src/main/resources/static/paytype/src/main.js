import Vue from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import PayType from './PayType.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(PayType)
}).$mount("#app")
