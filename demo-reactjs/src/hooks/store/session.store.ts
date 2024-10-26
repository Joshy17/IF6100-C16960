export type Session = {
	email: string;
	name: string;
};

export type SessionStore = {
	session: Session | null;
	setSession: (session: Session) => void;
	clearSession: () => void;
};

// eslint-disable-next-line @typescript-eslint/no-explicit-any
export const sessionStore = (set: any) => {
	return {
		session: null,
		setSession: (session: Session) => {
			set({ session });
		},
		clearSession: () => {
			set({ session: null });
		},
	};
};
