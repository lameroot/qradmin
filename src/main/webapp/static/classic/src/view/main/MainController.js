Ext.define('PayAdmin.view.main.MainController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.main',

	requires: [
		'PayAdmin.util.SessionManager',
		'PayAdmin.view.board.BoardView',
		'PayAdmin.view.login.LoginView'
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
					var showViewType = SessionManager.isAuthenticated()
						? 'boardView'
						: 'loginView';
					ths.showView(showViewType);
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
