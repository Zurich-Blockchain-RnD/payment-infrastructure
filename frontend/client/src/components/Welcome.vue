<template>
  <v-container>
  <v-layout column justify-center class="content">
    <v-flex>
      <h1>Welcome!</h1>
      <div class="subtext">
        Easily pay and get paid with cryptocurrencies!
      </div>
    </v-flex>
    <v-spacer></v-spacer>
    <v-layout>
      <button v-on:click='signIn'>Sign In</button>
      <button v-on:click='signIn'>Register</button>
    </v-layout>
  </v-layout>
</v-container>
</template>

<script>
  export default {
    methods: {
      signIn: function() {
        this.$router.replace('home')
      }
    }
  }
</script>

<style scoped>
  h1 {
    margin-top: 10%;
    background-color: transparent;
    font-size: 33px;
  }
  .subtext {
    margin-top: 10px;
    background-color: transparent;
    font-size: 18px;
  }
  .content {
    margin-left: 20%;
  }
  button {
    width: 150px;
    height: 70px;
    margin-top: 20px;
    margin-right: 20px;
    font-size: 16px;
  }
</style>
