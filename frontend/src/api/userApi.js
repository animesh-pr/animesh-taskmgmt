import axios from "./axiosConfig";

export const getUsers = () => {
  return axios.get("/users");
};

export const createUser = (name) => {
  return axios.post("/users", { name }); // ✅ correct JSON
};
