import UserPage from "./pages/UserPage";
import TaskPage from "./pages/TaskPage";

function App() {
  return (
    <div style={{ padding: "20px" }}>
      <h1>Task Management</h1>
      <UserPage />
      <hr />
      <TaskPage />
    </div>
  );
}

export default App;
