Ext.define('QrAdmin.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    afterRender: function() {
        this.checkForLogin();
    },

    checkForLogin: function(){
        var loggedIn = true;
        if (loggedIn) {
            this.getView().getComponent('loginView').show();
            this.getView().getComponent('boardView').hide();
        } else {
            this.getView().getComponent('loginView').hide();
            this.getView().getComponent('boardView').show();
        }
    }
});
