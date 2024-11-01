import { login } from '../../src/services/user.service';
import { useApiHandler } from '../../src/hooks/useApiHandler';
import { useSessionHandler } from '../../src/hooks/useSessionHandler';
import { LoginForm } from './types';
import {
	AuthenticationInput,
	AuthenticationResponse,
} from '../../src/models/users.models';

const useDependencies = () => {
	const { setSessionStore, clearSession } = useSessionHandler();
	const { handleMutation } = useApiHandler();
	//const { setErrorNotificaiton } = useNotificationHandler();
	//const navigate = useNavigate();

	const initialValues = {
		username: '',
		password: '',
	};
	const rules = {
		username: [
			{
				required: true,
				message: 'Por favor ingrese su usuario',
			},
		],
		password: [
			{
				required: true,
				message: 'Por favor ingrese su contraseña',
			},
		],
	};

	const handleLogin = async (values: LoginForm) => {
		const user: AuthenticationInput = {
			username: values.username,
			password: values.password,
		};
		clearSession();

		const { result, isError } = await handleMutation(login, user);
		if (isError) {
			//	setErrorNotificaiton(message);
		} else {
			const response = result as AuthenticationResponse;
			setSessionStore({ ...response });
			//	navigate('/');
		}
	};
	const handleCancel = () => {
		//	navigate('/');
	};

	return { initialValues, rules, handleLogin, handleCancel };
};

export default useDependencies;
