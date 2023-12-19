<script>

//Import
import  ContactForm from '../components/ContactForm.vue'
import axios from 'axios';

export default {

    components: { ContactForm },
    
    data() {
        return {
            images: null
        }
    },

    methods: {

        async fetchImage(){
            await axios.get('http://localhost:8080/api/admin/images').then(response => {
                this.images = response.data;
            }).catch(error => {
                console.error('Errore nella chiamata API', error);
            });
        },
    },

    mounted() {
        this.fetchImage();
    }
}


</script>



<template>

    <div class="card-container">
        <div class="card" style="width: 18rem;" v-for="image in this.images">
            <img :src="image.url" class="card-img-top" :alt="image.title">
            <div class="card-body">
                <h5 class="card-title">{{ image.title }}</h5>
                <p class="card-text">{{ image.description }}</p>
            </div>
        </div>
    </div>

    <ContactForm />

</template>




<style scoped lang="scss">


.card-container {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
    gap: 20px;

    .card {
        flex-basis: calc(100% / 4);
    }
}

</style>