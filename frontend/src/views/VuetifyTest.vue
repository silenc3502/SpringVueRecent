<template>
  <div align="center">
    <h2>Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New
    </router-link>
    <vuetify-test-form :list-array="pageArray"/>
  </div>
</template>

<script>
import VuetifyTestForm from '../components/VuetifyTestForm.vue'
import axios from 'axios'

export default {
  name: 'VuetifyTest',
  components: {
    VuetifyTestForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://localhost:7777/boards')
      .then(response => {
        console.log(response)
        this.pageArray = response.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
