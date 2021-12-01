<template>
  <div>
    <navegacao></navegacao>

    <div class="conteudo">
        <h1>Dados dos doadores</h1>
        <b-table striped responsive hover :items="doadores" :fields="campos">
            <template #cell(nome) = "data">
                <NuxtLink :to="`/doadores/${data.value}`">
                    <span>{{data.value}}</span>
                </NuxtLink>
            </template>
        </b-table>
    </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            campos:[
                
                {
                    key:"nome",
                    label:"Nome do Doador"
                },
                {
                    key:"email",
                    label:"E-mail do Doador"
                },
                {
                    key:"senha",
                    label:"Senha do Doador"
                }
            ],
            doadores:[
                {
                    idDoador: 1,
                    nome: "Fausto Silva",
                    email: "faustao@gmail.com",
                    senha: "dancadosfamosos"
                },
                {
                    idDoador: 2,
                    nome: "Rodrigo Faro",
                    email: "rodriguinho@gmail.com",
                    senha: "dancagatinhodanca"
                },
                {
                    idDoador: 3,
                    nome: "Raul Gil",
                    email: "vovoraul@gmail.com",
                    senha: "pegueseubanquinho"
                },
            ]
        }
    }

}
</script>