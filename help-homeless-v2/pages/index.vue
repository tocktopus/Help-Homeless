<template>
  <div>
    <Navegacao />
    <div>
      <h1>Lista de doações</h1>
      <b-table striped responsive hover :items="doacoes" :fields="fields">
        <template #cell(categoria)="data">
          <b-icon class="h2 mb-2" :icon="data.value"></b-icon>
        </template>
      </b-table>
    </div>
  </div>
</template>
 
<script>
    export default {
    async asyncData({$axios}){
       let data;
        try{
        const response = await $axios.$get("/doacoes");
        data = response.data;
        } catch(e){ //trata o erro se houver
        console.log(e);
        }
        return {data};
    },
        data: function(){
            return {
              fields:[
                {
                  key: "valor"
                },
                {
                  key: "instituicao"
                },

              ],
              doacoes:[
                {valor: "600", instituicao: "Anjos da Cidade"},
                {valor: "450", instituicao: "Vidas em Transformacao"},
                {valor: "300", instituicao: "Fundacao Padre Haroldo"},
              ]
            }
        }
    }
</script>