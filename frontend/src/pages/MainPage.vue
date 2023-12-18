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

    <h1>Hello</h1>

</template>




<style scoped lang="scss">

</style>