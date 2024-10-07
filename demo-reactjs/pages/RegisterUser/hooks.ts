import Password from "antd/es/input/Password";
import { RegisterUserForm } from "./types";

export const useDependencies = () => {

    const initialValues ={
        name: '',
        email:'',
        password:'',
    };
    const rules = {
		name: [
			{
				required: true,
				message: 'Por favor ingrese su nombre',
			},
		],
		email: [
			{
				required: true,
				message: 'Por favor ingrese su correo',
			},
		],
		password: [
			{
				required: true,
				message: 'Por favor ingrese su contraseña',
			},
		],
	};

	const handleSubmit = (parms: RegisterUserForm) => {
		console.log(`${parms.name} ${parms.email} ${parms.password}`);
	};

	return {
		handleSubmit,
		initialValues,
		rules,
	};
};