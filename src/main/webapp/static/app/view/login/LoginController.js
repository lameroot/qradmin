Ext.define('QrAdmin.view.login.LoginController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.login',

    requires: [
        'QrAdmin.util.SessionManager',
        'QrAdmin.view.board.Board'
    ],

    init: function () {
        var ths = this;
        SessionManager.on(
            {
                onLogin: function () {
                    console.log('onLogin');
                    ths.getView().destroy();
                },
                onLoginFailed: function () {
                    console.log('onLoginFailed');
                },
                onLoginError: function () {
                    console.log('onLoginError');
                }
            }
        );
    },
    onLoginButtonClick: function () {
        var ths = this;
        var viewModel = this.getView().getViewModel();
        var login = viewModel.get('login');
        var password = viewModel.get('password');
        SessionManager
            .login(login, password)
            .then(function () {
                if (SessionManager.isAuthenticated()) {
                    ths.redirectTo('board');
                } else {
                    ths.redirectTo('login');
                }
            })
            .catch(function () {
                console.log('network error'); //TODO
            });
    }
});
