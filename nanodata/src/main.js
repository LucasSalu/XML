import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import PrimeVue from 'primevue/config';
import Button from "primevue/button";
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import 'primevue/resources/themes/aura-light-green/theme.css';
import 'primeicons/primeicons.css';

const app = createApp(App)

app.use(router);
app.use(PrimeVue);
app.component(Button);
app.component(Column);
app.component(DataTable);

app.mount('#app')
