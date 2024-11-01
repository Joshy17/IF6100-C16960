import React from 'react';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
//import RegisterUser from '../pages/RegisterUser/index.tsx';
import Login from '../pages/Login/Login.tsx';
import './index.css';

createRoot(document.getElementById('root')!).render(
	<StrictMode>
		<Login />
	</StrictMode>,
);
