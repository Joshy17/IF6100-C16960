export type Notification = {
	message: string;
	type: 'success' | 'error';
};

export type NotificationStore = {
	notification: Notification | null;
	setNotification: (notification: Notification) => void;
	clearNotification: () => void;
};
export const notificationStore = (set: (state: Partial<NotificationStore>) => void) => {
	return {
		notification: null,
		setNotification: (notification: Notification) => {
			set({ notification });
		},
		clearNotification: () => {
			set({ notification: null });
		},
	};
};