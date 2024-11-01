import { create } from 'zustand';
import { sessionStore, SessionStore } from './store/session.store';

type AppStore = SessionStore;
export const useAppStore = create<AppStore>(set => ({
	...sessionStore(set),
}));
