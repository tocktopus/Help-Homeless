<template>

    <div>
        <navegacao></navegacao>
        <div class="conteudo">
            
            <h1>Adicionar novo doador</h1>
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

            <!--<div v-show="form.nome">
                <h4 v-if = "form.nome && form.senha">
                    <NuxtLink :to="`/${form.nome}/${form.senha}`"> Seus dados ja podem ser enviados </NuxtLink>
                </h4>
                <span v-else style="color: red;">Dados incompletos</span>
            </div>-->
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
        criarDoador(event) {
            event.preventDefault()

                    this.$bvModal.msgBoxOk('Doador criado com sucesso!', {
                        title:'Confirmação',
                        size: 'sm',
                        okVariant: 'success',
                        headerClass: 'p-2 border-bottom-0',
                        footerClass: 'p-2 border-top-0',
                        centered: true,
                    }).then(
                        () => {
                            this.limparCampos();
                        }
                    )
                    

               
            
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
