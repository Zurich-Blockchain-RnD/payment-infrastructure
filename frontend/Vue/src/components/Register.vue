<template>
  <v-layout justify-center>
  <v-form ref="form" v-model="valid" lazy-validation>
    <div class="registration_form">
      <h1>Register</h1>
      <v-text-field
      label="First Name"
      required
      ></v-text-field>
      <v-text-field
      label="Last Name"
      required
      ></v-text-field>
      <v-text-field
      label="E-Mail"
      required
      ></v-text-field>
      <v-text-field
      label="Password"
      required
      ></v-text-field>
      <v-text-field
      label="Repeat Password"
      required
      ></v-text-field>
      <input type="radio" unchecked>
      I read and understood the terms of use
      <br>
      <button v-on:click='signIn'>
        submit
      </button>
      <!-- <button @click="clear">clear</button> -->
    </div>
  </v-form>
  </v-layout>
</template>

<script>
export default {

    methods: {
      clear () {
        this.$refs.form.reset()
      },
      signIn: function() {
        this.$router.replace('home')
      }
    }
}
</script>

<style scoped>
  h1 {
    color: #80CD32;
    margin-bottom: 20px;
  }
  .registration_form {
    margin-top: 30%;
  }
  button {
    font-size: 16px;
    width: 42%;
    padding-top: 12px;
    padding-bottom: 12px;
    margin-top: 23px;
    margin-right: 15px;
  }
</style>
