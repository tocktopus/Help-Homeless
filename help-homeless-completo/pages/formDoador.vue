<template>

    <div>
        <navegacao></navegacao>
        <br>
        <div class="conteudo" style="padding: 0 15px 0 15px">
            
            <h1>Adicionar novo doador</h1>
            <br>
            <b-form @submit="criarDoador">
                <b-form-group
                id="nome"
                label="Nome:"
                label-for="nome">

                <b-form-input
                id="nome"
                v-model="form.nome"
                type="text"
                placeholder="Insira seu nome"
                >
                </b-form-input>
            </b-form-group>

            <b-form-group
                id="email"
                label="Email:"
                label-for="email">

                <b-form-input
                id="email"
                v-model="form.email"
                type="email"
                placeholder="Insira seu email"
                
                ></b-form-input>
            </b-form-group>

            <b-form-group
                id="senha"
                label="Senha:"
                label-for="senha">

                <b-form-input
                id="senha"
                v-model="form.senha"
                type="password"
                placeholder="Insira uma senha"
                
                ></b-form-input>
            </b-form-group>

            <b-button type="submit" variant="primary">Criar Doador</b-button>
            <b-button type="reset" variant="danger">Limpar Campos</b-button>

            </b-form>

        </div>
    </div>
    
    
</template>

<script>
import Navegacao from '../components/Navegacao.vue'
export default{
  components: { Navegacao },
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
        async criarDoador(event) {
            event.preventDefault()

            try{
                const dataDoador = await this.$axios.$post('/doadores/cadastrarDoador', this.form)
                // console.log(dataDoador);
                if (dataDoador !== null) {
                    this.$bvModal.msgBoxOk('Doador criado com sucesso!', {
                        title:'Confirmação',
                        size: 'sm',
                        okVariant: 'dark',
                        headerClass: 'p-2 border-bottom-0',
                        footerClass: 'p-2 border-top-0',
                        centered: true,
                    }).then(
                        () => {
                            this.limparCampos();
                        }
                    )
                }else{
                    throw new Error(`Não possível criar o doador ${this.form.nome}`);
                }
            } catch(error){

            }
                     
        },
        limparCampos(){
            this.form={
                nome: '',
                email:'',
                senha:''
            }
        },
    },
}
</script>
