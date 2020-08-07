<template>
  <div class="tictactoe">
    <div>{{ turn }}님의 턴입니다.</div>
    <table-component :table-data="tableData" v-bind:turn="turn"
      v-bind:winner="winner" v-on:updateTurn="updateTurn"
      v-on:updateTableData="updateTableData" v-on:updateWinner="updateWinner"></table-component>
    <div v-if="winner">{{ winner }}님의 승리!</div>
  </div>
</template>

<script>
import TableComponent from '../components/TableComponent.vue'

export default {
  components: {
    TableComponent
  },
  data () {
    return {
      turn: 'O',
      winner: '',
      tableData: [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    }
  },
  updated: function () {
    console.log('tableData: ' + this.tableData + ', turn: ' + this.turn + ', winner: ' + this.winner)
    console.log('propTurn: ' + this.propTurn)
  },
  methods: {
    updateTurn: function (val) {
      console.log('TicTacToe updateTurn: ' + val)
      this.turn = val
    },
    updateTableData: function () {
      this.tableData = [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    },
    updateWinner: function (val) {
      this.winner = val
    }
  },
  computed: {},
  mounted () {},
  beforeDestroy () {}
}

</script>
