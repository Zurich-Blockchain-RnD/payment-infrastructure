<template>
  <div class="recent">
    <div class="header">
      <h1>Recent</h1>
    </div>
    <div class="data_panel">
      <table class="table">
        <th></th>
        <th></th>
       <tbody>
         <tr v-for="purchase in purchases">
           <td>
             <div class="">
               <b>{{purchase.service}}</b>
             </div>
             <div class="">
               {{purchase.provider}}
             </div>
           </td>
           <td>
             <div class="">
               <b>-{{purchase.price}} CHF</b>
             </div>
             <div class="adr">
               {{purchase.addr}}
             </div>
           </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Recent',
  data () {
    return {
      purchases: [
      {
        service: 'Coffee',
        price: '6',
        addr: '0x732D145f57Ca26D1AF36849281BbDAb393Ea0F16',
        provider: 'Starbucks'
      },
      {
        service: 'Books',
        price: '21.6',
        addr: '0x732D145f57Ca26D1AF36849281BbDAb393Ea0F16',
        provider: 'Kosmos'

      }
    ]
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
  .recent {
    margin-top: 60px;
  }
  th {
    border-bottom: 1px solid;
    border-color: white;
  }

  td {
    border-top: 1px solid #ddd;
    background-color: transparent;
    border-color: red;
  }
</style>
