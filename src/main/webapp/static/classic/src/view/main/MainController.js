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

	showLoginView: function () {
		var view = this.getView();
		view.removeAll();
		view.add(
			Ext.create({
				xtype: 'loginView'
			})
		);
	},

	showBoardView: function () {
		var view = this.getView();
		view.removeAll();
		view.add(
			Ext.create({
				xtype: 'boardView'
			})
		);
	},

	checkForAuthentication: function () {
		var ths = this;
		SessionManager
			.updateUserInfo()
			.then(
				function () {
					if (SessionManager.isAuthenticated()) {
						ths.showBoardView();
					} else {
						ths.showLoginView();
					}
				},
				function () {
					console.log('network error'); //TODO
				}
			);
	}
});
