<template>
  <v-layout justify-center>
   <div class='metamask-info'>
     <p>Metamask: {{ web3.isInjected }}</p>
     <p>Network: {{ web3.networkId }}</p>
     <p>Account: {{ web3.coinbase }}</p>
     <p>Balance: {{ weiToEth(web3.balance)}}</p>
   </div>
</v-layout>
</template>

<script>
  export default {

    beforeCreate () {
      console.log('registerWeb3 Action dispatched from metamask-stats.vue')
      this.$store.dispatch('registerWeb3')
    },
    computed: {
      web3 () {
        return this.$store.state.web3
      }
    },
    methods: {
      weiToEth: function(wei) {
        let result = wei / 1000000000000000000
        return result
      }
    }
  }
</script>

<style scoped>
  .metamask-info {
    margin-top: 10%;
  }
</style>
