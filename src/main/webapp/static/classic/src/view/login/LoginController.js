Ext.define('QrAdmin.view.login.LoginController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.login',

	requires: [
		'QrAdmin.util.SessionManager'
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
					if (SessionManager.isAuthenticated()) {
						ths.redirectTo('board');
					} else {
						ths.redirectTo('login');
					}
				},
				function () {
					console.log('network error'); //TODO
				}
			);
	}
});
