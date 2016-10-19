Ext.define('PayAdmin.view.board.BoardController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.board',

	requires: [
		'PayAdmin.util.SessionManager'
	],

	onLogoutButtonClick: function () {
		var ths = this;
		SessionManager
			.logout()
			.then(
				function () {
					console.log('successful logout'); 
				},
				function () {
					console.log('network error'); //TODO
				}
			);
	}
});
