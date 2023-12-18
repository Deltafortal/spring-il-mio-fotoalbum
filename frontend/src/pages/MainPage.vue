<script>

//Import
import axios from 'axios';

export default {

    components: {},
    
    data() {
        return {
            images: null
        }
    },

    methods: {

        fetchImage(){
            axios.get('http://localhost:8080/api/admin/images').then(response => {
                this.images = response.data;
            }).catch(error => {
                console.error('Errore nella chiamata API', error);
            });
        },
    },

    created() {
        this.fetchImage();
    }
}


</script>



<template>

    <div class="card" style="width: 18rem;" v-for="image in this.images">
    <img :src="image.url" class="card-img-top" :alt="image.title">
    <div class="card-body">
        <h5 class="card-title">{{ image.title }}</h5>
        <p class="card-text">{{ image.description }}</p>
    </div>
    </div>

</template>




<style scoped lang="scss">

</style>