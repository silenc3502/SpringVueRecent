<template>
  <div align="center">
    <h2>Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New
    </router-link>
    <vuetify-board-list-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import VuetifyBoardListForm from '../components/VuetifyBoardListForm.vue'

export default {
  name: 'BoardListPage',
  components: {
    VuetifyBoardListForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://sample.bmaster.kro.kr/contacts')
      .then(response => {
        console.log(response)
        this.pageArray = response.data.contacts
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style>
h1 {
  color: #454545;
  text-align: center;
}
</style>
