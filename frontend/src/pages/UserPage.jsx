import { useEffect, useState } from "react";
import { createUser, getUsers } from "../api/userApi";

export default function UserPage() {
  const [name, setName] = useState("");
  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    const res = await getUsers();
    setUsers(res.data);
  };

  const handleAdd = async () => {
    if (!name.trim()) return;        // safety check
    await createUser(name);          // ✅ FIXED
    setName("");
    loadUsers();
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div>
      <h2>Create User</h2>

      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter name"
      />

      <button onClick={handleAdd}>Add</button>

      <ul>
        {users.map((u) => (
          <li key={u.id}>{u.name}</li>
        ))}
      </ul>
    </div>
  );
}
