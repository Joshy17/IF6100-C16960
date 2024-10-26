import {
	AuthenticationInput,
	AuthenticationResponse,
	RegisterUserRequest,
} from '../models/users.models';
import { doPost } from './http.service';

export const registerUser = async (
	user: RegisterUserRequest,
): Promise<Response> => {
	const response = await doPost<RegisterUserRequest, Response>(
		user,
		'/api/public/register',
	);

	return response;
};

export const login = async (
	user: AuthenticationInput,
): Promise<AuthenticationResponse> => {
	const result = await doPost<AuthenticationInput, AuthenticationResponse>(
		user,
		'/api/public/login',
	);
	return result;
};
