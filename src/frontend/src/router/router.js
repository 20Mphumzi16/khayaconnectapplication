import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/views/HomePage.vue';


import axios from "axios";
import LoginPage from "@/components/LoginPage.vue";

const routes = [

    { path: '/', name: 'HomePage', component: HomePage },
    { path: '/login', name: 'LoginPage', component: LoginPage },

     {
        path: '/admin-layout',
        component: MainLayout,
        children: [
            {
                path: '',
                redirect: '/admin-layout/comic-books'
            },


        ],
    },

    {
        path: '/customer',
        children: [
            { path: '', redirect: 'account' }, // Redirect to account as default

            {
                path: 'cartcheckout',
                name: 'CartCheckout',
                component: () => import('@/components/CartCheckout.vue'),
                props: route => ({ cartItems: route.params.cartItems }),
            },
        ],
    },
];


const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});


function isTokenExpired(token) {
    try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        return payload.exp * 1000 < Date.now();
    } catch (error) {
        console.error("Invalid token format:", error);
        return true; // Expire the token if there’s an issue
    }
}


router.beforeEach(async (to, from, next) => {
    const requiresAuth = to.meta.requiresAuth;
    const requiredRole = to.meta.role;
    const token = localStorage.getItem('authToken');

    // If the route requires authentication

    if (requiresAuth) {
        if (!token || isTokenExpired(token)) {
            // Redirect to login if no valid token
            return next({ name: 'LoginPage' });
        }

        // Decode the token and extract the user's role
        const payload = JSON.parse(atob(token.split('.')[1]));
        const userRole = payload.role;

        // Check if the user has the correct role to access the page
        if (requiredRole && userRole !== requiredRole) {
            // If the user does not have the required role, redirect to home or another page
            return next({ name: 'HomePage' });
        }
    }

    next(); // Allow the navigation
});

// Export the router instance
export default router;

//Axios global configuration to include JWT token in every request
axios.interceptors.request.use((config) => {
    const publicPaths = ['/Contact/create']; // List of public endpoints

    // Check if the request URL is not a public route
    if (!publicPaths.includes(config.url)) {
        const token = localStorage.getItem('authToken');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
    }

    return config;
}, (error) => {
    return Promise.reject(error);
});
axios.interceptors.response.use(
    response => response,
    error => {
        if (error.response && error.response.status === 401 || error.response.status === 403) {
            // Handle token expiration
            localStorage.removeItem('authToken');
            router.push({ name: 'LoginPage' });
        }
        return Promise.reject(error);
    }
);

