import  useNotificationHandler  from '../../src/hooks/useNotificationHandler';	

export const useDependencies = () => {
	const { notification, clearNotification } = useNotificationHandler();

	const onCloseMessage = () => {
		clearNotification();
	};
	return { notification, onCloseMessage };
};


export default useDependencies;