Ext.define('QrAdmin.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    requires: [
        'QrAdmin.util.SessionManager',
        'QrAdmin.view.board.Board',
        'QrAdmin.view.login.LoginView'
    ],

    afterRender: function() {
        this.checkForLogin();
    },

    checkForLogin: function(){
        var loggedIn = QrAdmin.util.SessionManager.isAuthenticated();
        this.getView().removeAll();
        var view = Ext.create({
            xtype: loggedIn ? 'boardView' : 'loginView'
        });
        this.getView().add(view);
    }
});
