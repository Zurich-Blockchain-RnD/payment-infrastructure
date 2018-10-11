<template>
  <div>
    <v-layout column justify-center>
      <div class="header">
        <h1>Confirm</h1>
      </div>
      <div class="data_panel">
        <v-layout column>
          <div class="provider">
            <b>Starbucks</b>
          </div>
          <v-layout>
            <div class="service">
              <b>Coffee</b>
            </div>
            <div class="price">
              <b>5.99 CHF</b>
            </div>
          </v-layout>

          <hr>

          <div class="balances">
            <b>Balances:</b>
          </div>
          <v-layout wrap >
            <div id="eth_adr">
              <div class="eth">
                <b>ETH</b>
              </div>
              <div class="adr">
                {{web3.coinbase}}
              </div>
            </div>
            <div class="ethamt">
              <b>{{weiToEth(web3.balance)}}</b>
            </div>
            <div class="chfamt">
              {{chfAmount}} CHF
            </div>
          </v-layout>
        </v-layout>
      </div>
      <v-layout justify-center>
        <div class="buttons">
          <button v-on:click="home" type="button" name="button">Cancel</button>
          <button v-on:click="home" type="button" name="button">Confirm</button>
        </div>
      </v-layout>
    </v-layout>
  </div>
</template>

<script>
export default {
  data () {
    return {
      ethAmount: '3.25',
      chfAmount: '725',
      adr: '0x732D145f57Ca26D1AF36849281BbDAb393Ea0F16'
    }
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
  methods: {
    home: function() {
      this.$router.replace('home')
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
button {
  font-size: 16px;
  width: 115px;
  padding-top: 12px;
  padding-bottom: 12px;
  margin-top: 23px;
  margin-right: 15px;
}
.buttons {
  width: 81%;
}
.provider {
  font-size: 18px;
}
.service {
  font-size: 30px;
  margin-right: 18%;
}
.price {
  font-size: 28px;
}
.balances{
  font-size: 20px;
}
#eth_adr {
  margin-right: 10%;
}
.adr {
  max-width: 90px;
  overflow: hidden;
  text-overflow: ellipsis;
  font-size: 10px;
}
.eth {
  font-size: 20px;
}
.ethamt {
  margin-right:10%;
  font-size: 25px;
}
.chfamt {
  font-size: 25px;
}
</style>
