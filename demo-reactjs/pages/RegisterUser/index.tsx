import { Button, Form, Input, Space } from 'antd';
import React from 'react';
import { useDependencies } from './hooks';

const RegisterUser = () => {
	const { initialValues, handleSubmit, rules } = useDependencies();
	return (
		<Form onFinish={handleSubmit} initialValues={initialValues}>
			<Space direction='vertical'>
				<Form.Item name='name' rules={rules.name}>
					<Input placeholder='Nombre' />
				</Form.Item>
				<Form.Item name='email' rules={rules.email}>
					<Input placeholder='Correo' />
				</Form.Item>
				<Form.Item name='password' rules={rules.password}>
					<Input placeholder='Contraseña' type='password' />
				</Form.Item>
				<Form.Item
					name='passwordConfirmation'
					rules={rules.passwordConfirmation}
				>
					<Input placeholder='Contraseña' type='password' />
				</Form.Item>
				<Button type='primary' htmlType='submit'>
					Registrar
				</Button>
			</Space>
		</Form>
	);
};
export default RegisterUser;
