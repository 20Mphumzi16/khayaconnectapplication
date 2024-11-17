import axios from 'axios';

const API_URL = 'http://localhost:8080/khayaconnection/product';


export const getAllItems = () => {
    return axios.get(`${API_URL}/getall`);
};
