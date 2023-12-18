<script>
//Import
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        email: '',
        message: '',
      },
    };
  },
  methods: {
    submitForm() {
      axios.post('http://localhost:8080/api/messages', this.formData)
      .then(response => {
          console.log('Messaggio inviato con successo', response);
          this.resetForm()
      });
    },
    resetForm() {
      this.formData.email = '';
      this.formData.message = '';
    },
  },
};

</script>



<template>

    <div>
        <h2>Contattaci</h2>
        <form @submit.prevent="submitForm">
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" v-model="formData.email" required />
        </div>
        <div>
            <label for="message">Messaggio:</label>
            <textarea id="message" v-model="formData.message" required></textarea>
        </div>
        <div>
            <button type="submit">Invia Messaggio</button>
        </div>
        </form>
    </div>

</template>




<style scoped lang="scss">

</style>