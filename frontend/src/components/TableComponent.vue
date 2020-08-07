<template>
  <table>
    <tr-component
      v-for="(rowData, index) in tableData"
      :key="index"
      :row-data="rowData"
      :row-index="index"
      v-bind:table-data="tableData"
      v-bind:turn="turn"
      v-bind:winner="winner"
      v-on:updateTurn="updateTurn"
      v-on:updateTableData="updateTableData"
      v-on:updateWinner="updateWinner"
      v-model="propTurn"
    ></tr-component>
  </table>
</template>

<script>
import TrComponent from './TrComponent'

export default {
  data () {
    return {
      propTurn: this.turn,
      propWin: this.winner
    }
  },
  components: {
    TrComponent
  },
  props: {
    tableData: Array,
    turn: String,
    winner: String
  },
  updated: function () {
    console.log('tableData: ' + this.tableData + ', turn: ' + this.turn + ', winner: ' + this.winner)
    console.log('propTurn: ' + this.propTurn)
  },
  methods: {
    updateTurn: function (val) {
      console.log('TableComponent updateTurn: ' + val)
      this.propTurn = val
      this.$emit('updateTurn', this.propTurn)
    },
    updateTableData: function () {
      this.$emit('updateTableData')
    },
    updateWinner: function (val) {
      this.propWin = val
      this.$emit('updateWinner', this.propWin)
    }
  }
}
</script>

<style>
table {
  border-collapse: collapse;
}
td {
  border: 1px solid black;
  width: 40px;
  height: 40px;
  text-align: center;
}
</style>
