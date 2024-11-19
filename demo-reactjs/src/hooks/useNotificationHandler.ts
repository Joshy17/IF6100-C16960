import { useAppStore } from './useAppStore';

const useNotificationHandler = () => {
	const setNotification = useAppStore(store => store.setNotification);

	const setErrorNotificaiton = (message: string) => {
		setNotification({ message, type: 'error' });
	};
	const setInfoNotificaiton = (message: string) => {
		setNotification({ message, type: 'success' });
	};

	const clearNotification = useAppStore(store => store.clearNotification);
	const notification = useAppStore(store => store.notification);

	return {
		setNotification,
		setErrorNotificaiton,
		setInfoNotificaiton,
		clearNotification,
		notification,
	};
};
export default useNotificationHandler;