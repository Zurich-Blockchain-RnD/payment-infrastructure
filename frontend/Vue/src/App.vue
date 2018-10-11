<template>
  <v-app>
    <v-toolbar
      app
      dark
      color="#80CD32"
      extended
      flat
    >
    <v-layout
      justify-center>
      <p class="toolbar_header"> {{title}} </p>
    </v-layout>
    </v-toolbar>

    <v-content>
      <router-view/>
    </v-content>

    <v-footer :fixed="fixed" app>
      <span>&copy; 2018</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data () {
    return {
      title: 'ReadyPay'
    }
  },
  name: 'App'
}
</script>

<style>
  .toolbar_header {
    font-size: 30px;
    margin-top: 8%;
  }
  button {
  border-radius: 6px;
  border-width: 2px;
  border-style: solid;
  border-color: #80CD32;
  background-color: #80CD32;
  color: #fff;
  cursor: pointer;
  transition: 0.25s ease;
  font-family: "Roboto", sans-serif;
  }
  button:hover {
    color: #80CD32;
    background: transparent;
  }

  .data_panel {
    margin: auto;
    padding: 15px;
    margin-top: 15px;
    width: 81%;
    border-radius: 6px;
    border-width: 1px;
    border-style: solid;
    border-color: #80CD32;
    background-color: transparent;
  }
</style>
