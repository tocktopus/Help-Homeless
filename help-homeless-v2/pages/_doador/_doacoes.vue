<template>
    <div>
        <navegacao></navegacao>
        <div class="conteudo">
          <h1> Realizar nova Doação </h1>
        <h1>Doações de {{ doador.nome }}</h1>
            <h4>{{ doador.email}}</h4> 
            <div>
                <b-button pill variant="danger" @click="showModal = true" >
                <b-icon icon="plus"></b-icon>
                </b-button>
            </div>
            <ul>
                <li :key="doacao.id" v-for="doacao in doacoes "><div size="sm">
            {{ doacao.valor }} - Instituição:
            {{ doacao.instituicao }}</div></li>
               
            </ul>
            <b-modal id="modal-doacao" v-model="showModal" size="lg"  hide-footer>
                <h1>Nova doação</h1>
                <b-container fluid>
                <b-row class="my-1">
                    <b-col sm="1">
                    <label for="valor">Valor:</label>
                    </b-col>
                    <b-col sm="4">
                    <b-form-input
                        id="valor"
                        v-model="novaDoacao.valor"
                        size="sm"
                        placeholder="Qual o valor de sua doação?"
                        type=number
                    ></b-form-input>
                    </b-col>
                    <b-col sm="2">
                    <label for="inst">Instituição:</label>
                    </b-col>
                    <b-col sm="5">
                    <b-form-input
                        id="inst"
                        v-model="novaDoacao.instituicao"
                        size="sm"
                        placeholder="Para onde deseja doar?"
                    >
                    </b-form-input>
                    </b-col>
                </b-row>
                </b-container>
                <b-button class="mt-3" block variant="success" @click="criarNovaDoacao"
                >Criar Doacao</b-button
                >
                <b-button class="mt-3" block variant="danger" @click="fecharModal">Fechar
                </b-button>
            </b-modal>
        </div>
    </div>
</template>

<script>
export default{
    asyncData({ params }) {
        let doacoes = [];
        if(params.doacoes === "Fausto Silva"){
            doacoes = [
                {
                    id: 1,
                    valor: 200,
                    instituicao: "Padre Haroldo",
                },
                {
                    id: 2,
                    valor: 600,
                    instituicao: "Anjos da Cidade",
                },
                {
                    id: 3,
                    valor: 80,
                    instituicao: "Anjos da Noite",
                },
            ]
        }else{
            doacoes = [
                {
                    id: 1,
                    valor: 0,
                    instituicao: "Instituicao qualquer",
                },
            ]
        }
        return {doacoes};
    },
     data() {
        return {
            showModal: false,
            doador:{
                nome: "Fausto Silva",
                email:  "faustao@gmail.com",
            },
            novaDoacao: {
                valor: '',
                instituicao: '',
            },
            selecionados: [],
        }
    },
   
     methods: {
         criarNovaDoacao(event) {
             this.doacoes.push({
                id: null,
                valor: this.novaDoacao.valor,
                instituicao: this.novaDoacao.instituicao,
            })
            this.fecharModal(event)
        },
        fecharModal(event) {
            this.novaDoacao = {
                valor: '',
                instituicao: '',
            }
            this.$bvModal.hide('modal-doacao')
        },
       
    },
}
</script>