Ext.define('PayAdmin.view.login.LoginController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.login',

	requires: [
		'PayAdmin.util.SessionManager'
	],

	onLoginButtonClick: function () {
		var ths = this;
		var viewModel = this.getView().getViewModel();
		var login = viewModel.get('login');
		var password = viewModel.get('password');
		SessionManager
			.login(login, password)
			.then(
				function () {
					console.log('successful login'); //TODO
				},
				function () {
					console.log('network error'); //TODO
				}
			);
	}
});
