Ext.define('QrAdmin.view.main.MainController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.main',

	requires: [
		'QrAdmin.util.SessionManager',
		'QrAdmin.view.board.BoardView',
		'QrAdmin.view.login.LoginView'
	],

	routes: {
		login: 'onLogin',
		board: 'onBoard'
	},

	onLogin: function () {
		var view = this.getView();
		view.removeAll();
		view.add(
			Ext.create({
				xtype: 'loginView'
			})
		);
	},

	onBoard: function () {
		var view = this.getView();
		view.removeAll();
		view.add(
			Ext.create({
				xtype: 'boardView'
			})
		);
	},

	afterRender: function () {
		var ths = this;
		SessionManager
			.updateUserInfo()
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
