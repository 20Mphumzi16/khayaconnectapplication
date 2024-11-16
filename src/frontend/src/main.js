import { createApp } from 'vue';

import App from './App.vue';

import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';


import {
    faCar,
    faBaby,
    faBolt,
    faHeart,
    faBook,
    faCampground,
    faTshirt,
    faTv,
    faUtensils,
    faFirstAid,
    faHome,
    faWineBottle,
    faPlane,
    faBriefcase,
    faPaw,
    faFootballBall,
    faGamepad,
    faStar,
    faChevronLeft,
    faChevronRight,
    faShoppingCart,
    faUser,
    faEnvelope,
    faGift,
    faCertificate,faBlog


} from '@fortawesome/free-solid-svg-icons';



// Add the icons you need to the FontAwesome library
library.add(
    faCertificate,
    faBlog,
    faGift,
    faEnvelope,
    faCar,
    faUser,
    faShoppingCart,
    faChevronLeft,
    faChevronRight,
    faBaby,
    faBolt,
    faHeart,
    faBook,
    faCampground,
    faTshirt,
    faTv,
    faUtensils,
    faFirstAid,
    faHome,
    faWineBottle,
    faPlane,
    faBriefcase,
    faPaw,
    faFootballBall,
    faGamepad,
    faStar
);

// Create the app and register the FontAwesomeIcon component globally
createApp(App)

    .component('font-awesome-icon', FontAwesomeIcon)
    .mount('#app');
