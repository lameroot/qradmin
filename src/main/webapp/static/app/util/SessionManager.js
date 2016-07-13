Ext.define('QrAdmin.util.SessionManager', {
    singleton: true,
    authenticated: true,

    isAuthenticated: function () {
        return this.authenticated;
    },
    authenticate: function () {
        Ext.Ajax.request({
            url: 'mvc/user/current',
            callback: function (options, success, response) {
                expired = !success;
                if (success == true && Ext.JSON.decode(response.responseText).success == true && Ext.JSON.decode(response.responseText).changepassword == true) {
                    manager.onChangePassword();
                } else if (success == true && Ext.JSON.decode(response.responseText).success == true) {
                    manager.onAuthenticated(Ext.JSON.decode(response.responseText, true));
                } else {
                    manager.onLogout();
                }
            }
        });
    }
});