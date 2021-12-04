<template>
  <div>
    <navegacao></navegacao>

    <br>

    <div class="conteudo">
        <h1>Dados dos doadores</h1>
        <br>
        <b-table striped responsive hover :items="doadores" :fields="campos">
            <template #cell(nome) = "data">
                <NuxtLink :to="`/doadores/${data.item.idDoador}`">
                    <span>{{data.value}}</span>
                </NuxtLink>
            </template>
        </b-table>
    </div>
  </div>
</template>

<script>
export default {
    async asyncData({$axios}){
        let doadores
        try{
            const response = await $axios.$get("/doadores");
            doadores = response;
        } catch(e){ 
            // console.log(e);
        }
        // console.log(JSON.stringify(doadores));
        return {doadores};
        
    },
    
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
            
        }
    }

}
</script>