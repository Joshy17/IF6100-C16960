import React, { useState } from "react";
import "./App.css";

function App() {
  const [name, setName] = useState("");
  const [names, setNames] = useState<String[]>([]);

  const addName = () => {
    setNames([...names, name]);
    console.log(names);
  };

  return (
    <>
      <div>{name}</div>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <button onClick={addName}>Agregar</button>
      <ul>
        {names.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </>
  );
}

export default App;
