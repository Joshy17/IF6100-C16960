import {
	getSessionToken,
	removeSessionToken,
	setSessionToken,
} from '../services/cookies.service';
import { jwtDecode } from 'jwt-decode';
//import { useAppStore } from './store/useAppStore';
import { useAppStore } from './useAppStore';
import { AuthenticationResponse } from '../models/users.models';
interface DecodedToken {
	exp: number;
	email: string;
}

export const useSessionHandler = () => {
	const isSessionExpired = (): boolean => {
		const token = getSessionToken();

		if (token === null || token === undefined) {
			return true;
		} else {
			// eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
			const { exp } = jwtDecode(token as string) as DecodedToken;
			return !(exp > Math.floor(Date.now() / 1000));
		}
	};
	const sessionContext = useAppStore(store => store.session);
	const setSessionContext = useAppStore(store => store.setSession);
	const clear = useAppStore(store => store.clearSession);

	const setSessionStore = (response: AuthenticationResponse) => {
		const { email, name, token } = response;
		setSessionContext({ email, name });
		setSessionToken(token);
	};
	const clearSession = () => {
		clear();
		removeSessionToken();
	};

	const loadSessionFromToken = () => {
		if (!isSessionExpired()) {
			const token = getSessionToken();

			if (token != null) {
				// eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
				const { email } = jwtDecode(token as string) as DecodedToken;
				setSessionContext({ email, name: email });
			}
		}
	};
	return {
		isSessionExpired,
		sessionContext,
		setSessionStore,
		clearSession,
		loadSessionFromToken,
	};
};
