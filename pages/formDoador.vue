<template>
 <div class="container">
     <h3></h3>
     <form @submit.prevent="digaOla">
         <span ref="nome">Nome: </span>
         <input id="nome" v-model="form.nome" type="text"/> <br> <br> 

         <span ref="email">Email: </span>
         <input id="email" v-model="form.email" type="email"/> <br> <br> 

         <span ref="senha">Senha: </span>
         <input id="senha" v-model="form.senha" type="password"/> <br> <br> 

         <!--<button type="submit">Ok</button>-->
     </form>

     <div v-show="form.nome">
         <h4 v-if = "form.nome && form.email && form.senha">
             <NuxtLink :to="`/${form.nome}/${form.email}/${form.senha}`"> Seus dados já podem ser enviados </NuxtLink>
         </h4>
         <span v-else style="color: red;">Dados incompletos</span>
     </div>
 </div>
</template>

<script>
export default{
    data(){
        return{
            form:{
                nome:'',
                email:'',
                senha:'',
            },
        }
    },
    methods:{
        digaOla(){
            alert(JSON.stringify(this.form))
        },
    },
}
</script>

<style scoped>
.container{
  margin: 20px;
}
</style>