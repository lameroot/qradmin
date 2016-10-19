Ext.define('QrAdmin.view.main.MainController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.main',

	requires: [
		'QrAdmin.util.SessionManager',
		'QrAdmin.view.board.BoardView',
		'QrAdmin.view.login.LoginView'
	],

	listen: {
		global: {
			logoutEvent : 'checkForAuthentication',
			loginEvent : 'checkForAuthentication'
		}
	},

	afterRender: function () {
		this.checkForAuthentication();
	},

	checkForAuthentication: function () {
		var ths = this;
		SessionManager
			.updateUserInfo()
			.then(
				function () {
					if (SessionManager.isAuthenticated()) {
						ths.showView('boardView');
					} else {
						ths.showView('loginView');
					}
				},
				function () {
					console.log('network error'); //TODO
				}
			);
	},

	showView: function (viewType) {
		var view = this.getView();
		view.removeAll();
		view.add(
			Ext.create({
				xtype: viewType
			})
		);
	}
});
