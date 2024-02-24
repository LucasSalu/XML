<template>
  <div>
    <div class="card">
        <DataTable :value="nFes" paginator :rows="5" :rowsPerPageOptions="[5, 10, 20, 50]" tableStyle="min-width: 50rem; max-width: 150rem" class="p-datatable-table" >
            <Column field="codigo" header="ID"></Column>
            <Column field="dhEmi" header="DATA EMISSÃO"></Column>
            <Column field="emmitCnpj" header="CNPJ EMISSORA"></Column>
            <Column field="destCnpj" header="CNPJ DESTINATARIO"></Column>
            <Column field="vtotTrib" header="VALOR TRIBUTARIO"></Column>
            <Column field="nnf" header="NUMERO NOTA"></Column>
            <Column field="xfant" header="NNF"></Column>
            <Column field="vnf" header="VALOR NOTA"></Column>
            <Column field="xnome" header="EMPRESA COMPRADORA"></Column>
            <Column header="Download">
              <template #body="slotProps">
                <i class="pi pi-download" @click="downloadFile(slotProps.data.binario.id)" style="cursor: pointer;"></i>
                <i class="pi pi-trash" @click="deleteFile(slotProps.data.id)" style="cursor: pointer; margin: 10px;"></i>
              </template>
            </Column>
          </DataTable>
    </div>
    
    <div class="file-upload">
        <div class="file-upload-controls">
            <label for="file-upload-input" class="file-upload-label">
                Escolher Arquivos
            </label>
            <input id="file-upload-input" type="file" @change="handleFileUpload" multiple>
            <button @click="submitFiles" class="submit-button">Enviar</button>
        </div>
        <div v-if=" selectedFiles.length > 0 && nFesError.length == 0" class="selected-files">
            <p>Arquivos selecionados:</p>
            <ul>
                <li v-for="(file, index) in selectedFiles" :key="index">{{ file.name }}</li>
            </ul>
        </div>
        <div v-if=" nFesError.length > 0" class="selected-files" style="color: red;">
            <p>Erro ao submeter arquivos:</p>
            <ul>
                <li v-for="(name, index) in nFesError" :key="index">{{ name }}</li>
            </ul>
        </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
 

export default {
  name:"App",
  data() {
      return {
          selectedFiles: [],
          nFes: [],
          nFesError:[],
      }
  },
  components:{
    DataTable,
    Column,

  },
  watch(){
    this.nFes,          
    this.selectedFiles,
    this.nFesError
  },
  async mounted() {
     this.nFes = await this.getNFes();
  },
  methods: {
        handleFileUpload(event) {
            this.selectedFiles = Array.from(event.target.files);
        },
        async submitFiles() {
            if (this.selectedFiles.length === 0) {
                console.error('Nenhum arquivo selecionado para enviar.');
                return;
            }

            const formData = new FormData();
            this.selectedFiles.forEach(file => {
                formData.append('files[]', file);
            });

            try {
                var response = await axios.post('http://localhost:8080/nfe', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });
            } catch (error) {
                console.error('Erro ao enviar arquivos:', error);
            }
            this.nFes = (await this.getNFes());
            this.nFesError = (await response).data[1];
            this.selectedFiles = [];
        },
        async getNFes(){
          try {
                const response = await axios.get('http://localhost:8080/nfe');
                return await response.data;
            } catch (error) {
                console.error('Erro ao enviar arquivos:', error);
            }
        },
        async downloadFile(fileId) {
          console.log(fileId);
          console.log(fileId);
          try {
            const response = await axios.get(`http://localhost:8080/binario/download/${fileId}`, {
              responseType: 'json' 
            });
          const byteCharacters = atob(response.data.conteudoArquivo);
          const byteNumbers = new Array(byteCharacters.length);

          for (let i = 0; i < byteCharacters.length; i++) {
              byteNumbers[i] = byteCharacters.charCodeAt(i);
          }
          const byteArray = new Uint8Array(byteNumbers);
          const blob = new Blob([byteArray], { type: 'application/octet-stream' });
          const url = window.URL.createObjectURL(blob);

 
          const link = document.createElement('a'); 
          link.href = url;
          link.setAttribute('download', response.data.nomeArquivo);
          document.body.appendChild(link);
          link.click();

          } catch (error) {
            console.error('Erro ao baixar o arquivo:', error);
          }
       },
       async deleteFile(idFile){
        try {
                const response = await axios.delete(`http://localhost:8080/nfe/${idFile}`);
                await response.data;
                this.nFes = this.nFes = (await this.getNFes());
                return response.data;
            } catch (error) {
                console.error('Erro ao deletar arquivos:', error);
            }
       }
    }
}
</script>

<style> 
.card{
margin: 10px;
}

.file-upload {
  margin-top: 5vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.file-upload-controls {
  display: flex;
  align-items: center;
}

.file-upload-label {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.file-upload-label:hover {
  background-color: #0056b3;
}

#file-upload-input {
  display: none;
}

.submit-button {
  margin-left: 10px;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #28a745;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-button:hover {
  background-color: #218838;
}

.selected-files {
  width: 300px;
  margin-top: 20px;
  text-align: center;
  align-items: center;
}

.selected-files p {
  margin-bottom: 10px;
  display: flex;;
  align-items: center;
}

.selected-files ul {
  list-style: none;
  padding: 0;
}

.selected-files li {
  margin-bottom: 5px;
}
</style>
