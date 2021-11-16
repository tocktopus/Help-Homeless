<template>
  <div class="container">
    <h1>Dados do funcionário</h1>
    <h4>Nome: {{ doador.nome }}</h4>
    <h4>Email: {{ doador.email }}</h4>
    <h4>Senha: {{ doador.senha }}</h4>
  </div>
</template>

<script>
export default {
  asyncData({ params }) {
    const doador = {
      nome: params.doadores, // recebe o valor do primeiro nível do path do link
      email: params.dados,
      senha: params.dados, // recebe o valor do segundo nível do path do link
    };
    console.log(doador); // Para Debug
    return { doador };
  },
}
</script>

<style>
/*Movido para assets\css\style.css para que seja global ao app
/* .container {
  margin: 20px;
} */
</style>