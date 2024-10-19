import React, { useState } from 'react';
import './App.css';
import Details from './Details';

function App() {
	const [name, setName] = useState('');
	const [names, setNames] = useState<string[]>([]);

	const addName = () => {
		setNames([...names, name]);
		console.log(names);
	};

	return (
		<>
			<div>{name}</div>
			<div>
				<input
					type='text'
					value={name}
					onChange={e => setName(e.target.value)}
				/>
				<button onClick={addName}>Agregar</button>

				<Details names={names} />
			</div>
		</>
	);
}

export default App;
