<template>
    <div>
        <navegacao></navegacao>
        
        <div class="conteudo">
 
            <br>
            <div  style="padding-left: 3%">
                <h2>Lista de doações de {{ doador.nome }} <b-button pill variant="dark" @click="deletarDoador()" ><b-icon icon="x"></b-icon> Deletar doador</b-button></h2>
                <br>
            </div>
            <ul style="padding-left: 4%">
                <li v-for="doacao in doador.doacoes" :key="doacao.idDoacao" >
                    <div size="sm">
                        Valor: R${{ doacao.valor }} - Data da doação:
                        {{ formatarData(new Date(doacao.data)) }} - ID: 
                        {{ doacao.idDoacao }}
                        &nbsp;
                        <v-button v-b-modal="'atualizar-doacao'" style="cursor: pointer"><b-icon icon="pencil-square"  @click="id = doacao.idDoacao"></b-icon></v-button>
                        
                    </div>
                </li>
            </ul>
            <br>
             <h4 style="padding-left: 3%"> Realizar nova doação: </h4>
             <div style="padding-left: 3%">
                <b-button v-b-modal="'criar-doacao'" pill variant="danger">
                <b-icon icon="plus"></b-icon> Nova doação
                </b-button>
            </div>

            <!--  MODAL PARA CRIAR UMA NOVA DOACAO -->
            <b-modal id="criar-doacao" size="lg"  hide-footer>
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
                        placeholder="Insira o valor da doação"
                        type=number
                    ></b-form-input>
                    </b-col>

                    <b-col sm="2">
                    <label for="inst">Data da doação:</label>
                    </b-col>
                    <b-col sm="5">
                    <b-form-datepicker
                        id="data"
                        v-model="novaDoacao.data"
                        :date-format-options="{
                        day: 'numeric',
                        month: 'numeric',
                        year: 'numeric',
                        }"
                        class="mb-2"
                    >
                    </b-form-datepicker>
                    </b-col>
                </b-row>
                </b-container>
                <b-button class="mt-3" block variant="success" @click="criarNovaDoacao"
                >Criar Doacao</b-button
                >
                <b-button class="mt-3" block variant="danger" @click="fecharModalCriar">Fechar
                </b-button>
            </b-modal>
            
            <!-- MODAL PARA ATUALIZAR UMA DOACAO -->
            <b-modal id="atualizar-doacao" size="lg"  hide-footer>
                <h1>Atualizando doação</h1>
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
                        placeholder="Insira o novo valor da doação"
                        type=number
                    ></b-form-input>
                    </b-col>

                    <b-col sm="2">
                    <label for="inst">Data da doação:</label>
                    </b-col>
                    <b-col sm="5">
                    <b-form-datepicker
                        id="data"
                        v-model="novaDoacao.data"
                        :date-format-options="{
                        day: 'numeric',
                        month: 'numeric',
                        year: 'numeric',
                        }"
                        class="mb-2"
                    >
                    </b-form-datepicker>
                    </b-col>
                </b-row>
                </b-container>
                <b-button class="mt-3" block variant="success" @click="atualizarDoacao(id)"
                >Atualizar Doacao</b-button
                >
                <b-button class="mt-3" block variant="danger" @click="fecharModalAtualizar">Fechar
                </b-button>
            </b-modal>
            
            <br>
            <h2 style="padding-left: 3%">Para onde vão suas doações?</h2>
<center>
<b-row >
	<div style="padding-left:2%; padding-top: 1% ">
		<b-card 
			title="Distribuição de alimentos"
			img-src="https://i.imgur.com/xBHNFoK.jpg"
			img-alt="Image"
			img-top
			tag="article"
			style="max-width: 20rem;"
			class="mb-2"
		>
			<b-card-text>
			  Suas doações podem ser utilizadas para auxiliar no preparo e na distribuição de refeições nutritivas para moradores de rua.
			</b-card-text>

		</b-card>
	</div>

	<div style="padding-left: 1%; padding-top: 1%">
		<b-card
			title="Itens de higiene"
			img-src="https://bandnewscwb.b-cdn.net/band/wp-content/uploads/2019/05/08.01.18-PRODUTOS-HIGIENE-PESSOAL-PREFEITURA-DE-VINHEDO.jpg"
			img-alt="Image"
			img-top
			tag="article"
			style="max-width: 20rem;"
			class="mb-2"
		>
			<b-card-text>
			  Os valores doados também são utilizados na arrecadação de produtos de higiene, como sabonetes, papel higiênico, entre outros.
			</b-card-text>
		</b-card>
	</div>

	<div style="padding-left: 1%; padding-top: 1%">
		<b-card
			title="Construção de moradias"
			img-src="http://saodesiderio.ba.gov.br/wp-content/uploads/2017/07/foto-1-7.jpg"
			img-alt="Image"
			img-top
			tag="article"
			style="max-width: 20rem;"
			class="mb-2"
		>
			<b-card-text>
				O Help Homeless também trabalha em parceria com instituições voltadas para a construção de moradias para famílias em situação de rua.
			</b-card-text>
		</b-card>
	</div>
    	<div style="padding-left: 1%; padding-top: 1%">
		<b-card
			title="Acesso a Saúde"
			img-src="https://exame.com/wp-content/uploads/2020/08/size_960_16_9_planos-saude-custo1.jpg?quality=70&strip=info&resize=680,453.jpg"
			img-alt="Image"
			img-top
			tag="article"
			style="max-width: 20rem;"
			class="mb-2"
		>
			<b-card-text>
			 As instituições beneficiadas também permitem que os necessitados usufruam da saúde pública, dando-os condução e direcionamento.
			</b-card-text>
		</b-card>
	</div>
</b-row>
</center>
        </div>
    </div>
</template>

<script>
export default{
    async asyncData({$axios, params}){
        let doador
        try{
            const response = await $axios.$get(`/doadores/${params.doacoes}`);
            doador = response;
        } catch(e){ 
            // console.log(e);
        }
        // console.log(JSON.stringify(doador));
        return {doador};
        
    },
    
     data() {
        return {
            showModal: false,
            novaDoacao: {
                valor: '',
                data: '',
            }
        }
    },
   
    methods: {
        // criando uma nova doacao
        async criarNovaDoacao(event) {
            
            try {
                const dataDoacao = await this.$axios.$post(
                    `/doadores/${this.doador.idDoador}/efetuarDoacao`,
                    this.novaDoacao
                )
                if (dataDoacao !== null) {
                    this.fecharModalCriar(event)
                    this.novaDoacao = {
                        valor: '',
                        data: null,
                    }
                    this.refreshDoacoes(); 
                    this.$bvModal.msgBoxOk('Doação criada com sucesso.', {
                        title:'Confirmação',
                        size: 'sm',
                        okVariant: 'dark',
                        headerClass: 'p-2 border-bottom-0',
                        footerClass: 'p-2 border-top-0',
                        centered: true,
                    })
                } else{
                    throw new Error(`Doacao para o doador de id ${this.doador.idDoador} não foi criada!`);
                }
            } catch (error) {
                // console.log(error)
            } 
        },

        async refreshDoacoes(){
            this.doador = await this.$axios.$get(`/doadores/${this.doador.idDoador}`);
        },

        fecharModalAtualizar(event) {
            this.novaDoacao = {
                valor: '',
                data: '',
            }
            this.$bvModal.hide('atualizar-doacao')
        },

        fecharModalCriar(event) {
            this.novaDoacao = {
                valor: '',
                data: '',
            }
            this.$bvModal.hide('criar-doacao')
        },

        formatarData(date) {
            return ((date.getDate()+1) + '/' + (date.getMonth() + 1) + '/' + date.getFullYear())
        },

        // deletando o doador
        async deletarDoador(){
            try{
                this.doador = await this.$axios.$delete(`/doadores/deletarDoador/${this.doador.idDoador}`);
                this.$bvModal.msgBoxOk('Doador apagado com sucesso.', {
                        title:'Confirmação',
                        size: 'sm',
                        okVariant: 'dark',
                        headerClass: 'p-2 border-bottom-0',
                        footerClass: 'p-2 border-top-0',
                        centered: true,
                }).then(
                        () => {
                            window.location.href = "/doadores";
                        }
                    )
            }catch(e){
                // console.log(e);
            }
        },

        // atualizando a doacao
        async atualizarDoacao(id, event){
            try {
                const dataDoacao = await this.$axios.$put(`/doadores/alterarDoacao/${id}`, 
                this.novaDoacao);

                if (dataDoacao !== null) {
                    this.fecharModalAtualizar(event)
                    this.novaDoacao = {
                        valor: '',
                        data: null,
                    }
                    this.refreshDoacoes(); 
                    this.$bvModal.msgBoxOk('Doação de ID ' + id + ' atualizada com sucesso.', {
                        title:'Confirmação',
                        size: 'sm',
                        okVariant: 'dark',
                        headerClass: 'p-2 border-bottom-0',
                        footerClass: 'p-2 border-top-0',
                        centered: true,
                    })
                } else{
                    throw new Error(`Doacao para o doador de id ${this.doador.idDoador} não foi atualizada!`);
                }
            } catch (error) {
                // console.log(error)
            }
        },

    },
}
</script>