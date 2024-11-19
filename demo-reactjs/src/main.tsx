import React from 'react';
import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
//import RegisterUser from '../pages/RegisterUser/index.tsx';
//import Login from '../pages/Login/Login.tsx';
import './index.css';
import Application from './Application.tsx';

createRoot(document.getElementById('root')!).render(
	<StrictMode>
		<Application />
	</StrictMode>,
);
