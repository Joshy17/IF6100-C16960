import { Button, Card, Divider, Form, Input, Space } from 'antd';
import useDependencies from './hooks';
import React from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
	const { handleLogin, handleCancel, rules } = useDependencies();
	//TODO mover este useNavigate para el hook de dependencies
	const navigate = useNavigate();
	const goToRegister = () => {
		navigate('/Register');
	};
	return (
		<>
			<Card title='Login'>
				<Form onFinish={handleLogin} autoComplete='off'>
					<Space direction='vertical' style={{ width: '100%' }}>
						<Form.Item name='username' rules={rules.username}>
							<Input placeholder='Username' />
						</Form.Item>{' '}
						<Form.Item name='password' rules={rules.password}>
							<Input placeholder='Password' type='password' />
						</Form.Item>
					</Space>
					<Divider />
					<Space wrap style={{ width: '100%' }} direction='horizontal'>
						<Button type='primary' shape='round' size='large' htmlType='submit'>
							Login
						</Button>
						<Button shape='round' size='large' onClick={handleCancel}>
							Back
						</Button>
					</Space>
				</Form>

				<Button
					type='primary'
					shape='round'
					size='large'
					onClick={goToRegister}
				>
					Register
				</Button>
			</Card>
		</>
	);
};

export default Login;
