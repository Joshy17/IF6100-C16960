import { create } from 'zustand';
import { sessionStore, SessionStore } from './session.store';
import { notificationStore, NotificationStore } from './notifications';

type AppStore = SessionStore & NotificationStore;
export const useAppStore = create<AppStore>(set => ({
	...sessionStore(set),
	...notificationStore(set),
}));