<script>
//Import
import AppHeader from './components/AppHeader.vue'

export default {

  components: {AppHeader}
}

</script>



<template>

  <AppHeader />

  <div class="container mb-5">

    <!-- Pages -->
    <main>
      <RouterView />
    </main>

  </div>

</template>




<style lang="scss">

  main {
    height: 90vh;
  }

</style>
