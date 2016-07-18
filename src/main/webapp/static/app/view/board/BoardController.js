Ext.define('QrAdmin.view.board.BoardController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.board',

    requires: [
        'QrAdmin.util.SessionManager'
    ],

    onLogoutButtonClick: function () {
        var ths = this;
        SessionManager
            .logout()
            .then(function () {
                ths.redirectTo('login');
            })
            .catch(function () {
                console.log('network error'); //TODO
            });
    }
});
