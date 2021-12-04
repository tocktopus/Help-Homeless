<template>
   <div>
      <b-navbar toggleable="lg" type="dark" variant="danger">
          <b-navbar-brand href="/" style="font-family: 'Trebuchet MS', sans-serif; font-size: 22px">
            <b-img height=40px rounded="circle" src="https://i.imgur.com/mcSgLPy.jpg"></b-img> HELP HOMELESS
          </b-navbar-brand>
          <b-navbar-nav class="ml-auto">
            <b-nav-form>
                <b-button to="/formDoador" size="sm" class="mr-sm-2">
                    Novo Doador
                </b-button>
            </b-nav-form>

            <b-nav-form>
                <b-button to="/doadores" size="sm" class="mr-sm-2">
                    Todos os Doadores
                </b-button>
            </b-nav-form>
          </b-navbar-nav>
      </b-navbar>
   </div>
</template>
