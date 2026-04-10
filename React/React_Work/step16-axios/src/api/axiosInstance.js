import axios from "axios";

const url = import.meta.env.VITE_API_SERVER_IP;

const axiosInstance = axios.create({
	baseURL: url,
	timeout: 5000,
});

export default axiosInstance;
