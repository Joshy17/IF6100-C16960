import { useApiHandler } from '../../src/hooks/useApiHandler';
import { RegisterUserRequest } from '../../src/models/users.models';
import { registerUser } from '../../src/services/user.service';
import { RegisterUserForm } from './types';

export const useDependencies = () => {
	const { handleMutation } = useApiHandler();
	const initialValues = {
		name: '',
		email: '',
		password: '',
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
		passwordConfirmation: [
			{
				required: true,
				message: 'Por favor ingrese su contraseña',
			},
		],
	};

	const handleSubmit = async (parms: RegisterUserForm) => {
		//validar que las contraseñas sean iguales
		if (parms.password !== parms.passwordConfirmation) {
			return;
		}

		const request: RegisterUserRequest = {
			user: parms.name,
			email: parms.email,
			password: parms.password,
		};
		const { isError, message } = await handleMutation(registerUser, request);

		if (isError) {
			console.log(message);
			return;
		}
		console.log(`${parms.name} ${parms.email} ${parms.password}`);
	};

	return {
		handleSubmit,
		initialValues,
		rules,
	};
};
