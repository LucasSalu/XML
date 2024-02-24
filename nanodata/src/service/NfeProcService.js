import axios from 'axios';

async function insertNfes(formData) {
    try {
        const response = await axios.post('http://localhost:8080/nfe', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log('Resposta do servidor:', response.data);
        // Aqui você pode tratar a resposta do servidor conforme necessário
    } catch (error) {
        console.error('Erro ao enviar arquivos:', error);
        // Aqui você pode tratar os erros de envio
    }
}