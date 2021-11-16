<template>
  <div class='container'>
    <h1>
      {{titulo}}
    </h1>
    <ul>
      <li v-for="item in doadores" :key="item.idDoador" >
        {{item.nome}} - Email: {{item.email}} / Senha: {{item.senha}}
      </li>
    </ul>
    <button @click="digaOla">Diga Olá!</button>
  </div>
</template>

<script>
export default {
  data(){
    return{
      titulo: 'lista de Doadores',
      doadores:[
        {idDoador: 1, nome: 'João', email: 'joao@gmail.com', senha:'12345jo'},
        {idDoador: 2, nome: 'Maria', email: 'maria@gmail.com', senha:'mari888'},
        {idDoador: 3, nome: 'Pedro', email: 'pedro@gmail.com', senha:'pedro5005'},
        {idDoador: 4, nome: 'Ana', email: 'ana@gmail.com', senha:'banana5'},
      ],
    }
  },
  methods:{
    digaOla(){
      alert("Olá mundo do nuxt.js");
    }
  }
}
</script>

<style scoped>
.container{
  margin: 20px;
}
</style>