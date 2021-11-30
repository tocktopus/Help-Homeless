<template>
   <div>
      <b-navbar toggleable="lg" type="dark" variant="danger">
          <b-navbar-brand href="#">Doadores</b-navbar-brand>
          <b-navbar-nav class="ml-auto">
            <b-nav-form>
                <b-button to="/formDoador" size="sm" class="mr-sm-2">
                    Novo Doador
                </b-button>
            </b-nav-form>

            <b-nav-form>
                <b-button to="/doador" size="sm" class="mr-sm-2">
                    Todos os Doadores
                </b-button>
            </b-nav-form>
          </b-navbar-nav>
      </b-navbar>
   </div>
</template>
