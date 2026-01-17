import { useEffect, useState } from "react";
import { createTask, getTasksByUser, updateTaskStatus } from "../api/taskApi";
import { getUsers } from "../api/userApi";

export default function TaskPage() {
  const [users, setUsers] = useState([]);
  const [selectedUserId, setSelectedUserId] = useState("");
  const [title, setTitle] = useState("");
  const [tasks, setTasks] = useState([]);

  // Load users for dropdown
  useEffect(() => {
    const loadUsers = async () => {
      const res = await getUsers();
      setUsers(res.data);
    };
    loadUsers();
  }, []);

  // Load tasks when user changes
  useEffect(() => {
    if (selectedUserId) {
      loadTasks();
    } else {
      setTasks([]);
    }
  }, [selectedUserId]);

  const loadTasks = async () => {
    const res = await getTasksByUser(selectedUserId);
    setTasks(res.data);
  };

  const handleAddTask = async () => {
    if (!title.trim() || !selectedUserId) return;

    await createTask(title, selectedUserId); // ✅ FIXED
    setTitle("");
    loadTasks();
  };

  const handleStatusChange = async (taskId, newStatus) => {
    await updateTaskStatus(taskId, newStatus);
    loadTasks();
  };

  return (
    <div>
      <h2>Create Task</h2>

      <select
        value={selectedUserId}
        onChange={(e) => setSelectedUserId(e.target.value)}
      >
        <option value="">Select User</option>
        {users.map((u) => (
          <option key={u.id} value={u.id}>
            {u.name}
          </option>
        ))}
      </select>

      <br /><br />

      <input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="Enter task title"
      />

      <button onClick={handleAddTask}>Add Task</button>

      <ul>
        {tasks.map((t) => (
          <li key={t.id}>
            {t.title} — <b>{t.status}</b>

            <button onClick={() => handleStatusChange(t.id, "DONE")}>
              Mark Done
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}