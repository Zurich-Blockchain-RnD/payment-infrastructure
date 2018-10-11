<template>
  <v-container>
  <v-layout column justify-center>

    <v-layout column justify-center>
      <div class="header">
        <h1>Wallet</h1>
      </div>
      <div class="data_panel">
        <v-layout wrap >
          <div id="eth_adr">
            <div class="eth">
              <b>ETH</b>
            </div>
            <div class="adr">
              {{web3.coinbase }}
            </div>
          </div>
          <div class="ethamt">
            <b>{{weiToEth(web3.balance)}}</b>
          </div>
          <div class="chfamt">
            {{chfAmount}} CHF
          </div>
        </v-layout>
      </div>
    </v-layout>

    <v-layout id="buttons" justify-center>
      <button class="wallet_btns">Add Funds</button>
      <button class="wallet_btns">My Profile</button>
      <button v-on:click='confirm' class="pay_btn">Pay</button>
    </v-layout>

    <recent />

  </v-layout>
</v-container>
</template>

<script>
import Recent from '@/components/Recent'

export default {
  components: {
    Recent
  },
  beforeCreate () {
    console.log('registerWeb3 Action dispatched from metamask-stats.vue')
    this.$store.dispatch('registerWeb3')
  },
  computed: {
    web3 () {
      return this.$store.state.web3
    }
  },
  data () {
    return {
      ethAmount: '3.25',
      chfAmount: '725',
      adr: '0x732D145f57Ca26D1AF36849281BbDAb393Ea0F16'
    }
  },
  methods: {
    confirm: function() {
      this.$router.replace('confirm')
    },
    weiToEth: function(wei) {
      let result = wei / 1000000000000000000
      return result
    }
  }
}
</script>

<style scoped>
  .header {
    width: 81%;
    margin: auto;
    color: #80CD32;
  }
  #eth_adr {
    margin-right: 10%;
  }
  .adr {
    max-width: 90px;
    overflow: hidden;
    text-overflow: ellipsis;
  }
  .eth {
    font-size: 20px;
  }
  .ethamt {
    margin-right:10%;
    font-size: 30px;
  }
  .chfamt {
    font-size: 30px;
  }
  button {
    padding-top: 12px;
    padding-bottom: 12px;
    margin-top: 20px;
  }
  .wallet_btns {
    width: 24.5%;
    margin-right: 1%;
    font-size: 16px;
  }
  .pay_btn {
    width: 30%;
    font-size: 28px;
    font-weight: bold;
  }
</style>
