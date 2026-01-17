import api from "./axiosConfig";

export const createTask = (task) => api.post("/tasks", task);
export const getTasksByUser = (userId) =>
  api.get(`/tasks/user/${userId}`);

export const updateTaskStatus = (taskId, status) =>
  api.put(`/tasks/${taskId}/status`, { status });
