<template>
  <div>
    <Navegacao />
    <div>
      <br>
      <center>
        <h1 style="font-family: 'Trebuchet MS', sans-serif;">Help Homeless</h1>
        <h4>Conectando doadores a necessitados</h4>
      </center>
      <br>
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="3000"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="200"
        style="text-shadow: 1px 1px 2px black;"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >

      <b-carousel-slide caption="Doação de agasalhos"
        text="Suas doações podem ser utilizadas para auxiliar na compra e distribuição de agasalhos em épocas de frio" 
        img-src="https://i.imgur.com/bUS9kSR.png" style="height:400px"></b-carousel-slide>
        
      <b-carousel-slide caption="Doação de alimentos"
        text="Suas doações podem ser utilizadas para auxiliar na distribuição de alimentos e no preparo de refeições nutritivas para moradores de rua."
        img-src="https://catracalivre.com.br/wp-content/thumbnails/KbNSOxlfqN3gmGF4W0hWgbd-ARU=/wp-content/uploads/2021/01/istock-1208790368.jpg" style="height:400px"> </b-carousel-slide>



      <b-carousel-slide caption="Doação de produtos de higiene"
        text="Suas doações também podem ser usadas para a arrecadação de produtos de higiene, como sabonetes, papel higiênico, entre outros."
        img-src="https://www.portalmorada.com.br/assets/uploads/noticias/campanha-natal-solidario-arrecada-itens-de-higiene-pessoal-para-asilos-GVjA.jpg" style="height:400px"></b-carousel-slide>
      </b-carousel>

      <br>
      <br>
      <center>
        <h1 style="font-family: 'Trebuchet MS', sans-serif;">Quem somos?</h1>
        <div style="width: 80%">
          <p>Somos um grupo de garotas inquietas com a situação dos moradores de rua, além de estarmos ajudando ao próximo, adquirimos conhecimento no desenvolvimento desta nobre causa.</p>
        </div>

        <br>

        <div class="imagens">
          <img src="https://i.imgur.com/mzbbjTR.jpg" height=300px>
          <img src="https://i.imgur.com/44YCivb.jpg" height=300px>
          <img src="https://i.imgur.com/fMcug1U.jpg" height=300px>
        </div>
      </center>

      <br>
      <br>

 

    </div>
  </div>
</template>
 
<script>
    export default {
    data() {
      return {
        slide: 0,
        sliding: null
      }
    },
    methods: {
      onSlideStart(slide) {
        this.sliding = true
      },
      onSlideEnd(slide) {
        this.sliding = false
      }
    }
  }
</script>

