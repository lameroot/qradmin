Ext.define('QrAdmin.view.login.LoginController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.login',

    requires: [
        'QrAdmin.util.SessionManager'
    ],

    onLoginButtonClick: function(){
        var viewModel = this.getView().getViewModel();
        SessionManager.login(viewModel.get('login'), viewModel.get('password'));
    }
});
