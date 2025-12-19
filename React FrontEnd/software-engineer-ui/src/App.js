import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [engineers, setEngineers] = useState([]);
  const [name, setName] = useState("");
  const [techStack, setTechStack] = useState("");
  const [editingId, setEditingId] = useState(null);

  // Fetch all engineers
  const fetchEngineers = () => {
    fetch("http://localhost:9090/api/v1/software-engineers")
      .then(res => res.json())
      .then(data => setEngineers(data));
  };

  useEffect(() => {
    fetchEngineers();
  }, []);

  // Add or Update engineer
  const saveEngineer = () => {
    if (!name || !techStack) {
      alert("Name and Tech Stack are required");
      return;
    }

    if (editingId === null) {
      const newLocal = "http://localhost:9090/api/v1/software-engineers";
      // ADD
      fetch(newLocal, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, techStack })
      }).then(() => {
        resetForm();
        fetchEngineers();
      });
    } else {
      // UPDATE
      fetch(`http://localhost:9090/api/v1/software-engineers/${editingId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, techStack })
      }).then(() => {
        resetForm();
        fetchEngineers();
      });
    }
  };

  // Delete engineer
  const deleteEngineer = (id) => {
    fetch(`http://localhost:9090/api/v1/software-engineers/${id}`, {
      method: "DELETE"
    }).then(() => {
      setEngineers(engineers.filter(e => e.id !== id));
    });
  };

  // Load data into form for editing
  const editEngineer = (engineer) => {
    setEditingId(engineer.id);
    setName(engineer.name);
    setTechStack(engineer.techStack);
  };

  const resetForm = () => {
    setEditingId(null);
    setName("");
    setTechStack("");
  };

  return (
  <div className="container">
    <h2>Software Engineers</h2>

    <input
      placeholder="Name"
      value={name}
      onChange={e => setName(e.target.value)}
    />

    <input
      placeholder="Tech Stack"
      value={techStack}
      onChange={e => setTechStack(e.target.value)}
    />

    <button className="add" onClick={saveEngineer}>
      {editingId ? "Update" : "Add"}
    </button>

    {editingId && (
      <button className="cancel" onClick={resetForm}>
        Cancel
      </button>
    )}

    <hr />

    {engineers.length === 0 ? (
      <p className="empty">No software engineers found.</p>
    ) : (
      <ul>
        {engineers.map(e => (
          <li key={e.id}>
            <span>{e.name} - {e.techStack}</span>
            <span>
              <button className="edit" onClick={() => editEngineer(e)}>Edit</button>
              <button className="delete" onClick={() => deleteEngineer(e.id)}>Delete</button>
            </span>
          </li>
        ))}
      </ul>
    )}
  </div>
);

}

export default App;
