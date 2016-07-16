Ext.define('QrAdmin.util.SessionManager', {
    singleton: true,
    authenticated: false,
    alternateClassName: 'SessionManager',
    urls: {
        loginUrl: '/api/security/login'
    },
    user: null,

    isAuthenticated: function () {
        return user != null;
    },
    login: function (login, password) {
        Ext.Ajax.request({
            url: this.urls.loginUrl,
            jsonData:{
                login: login,
                password: password
            },
            success: function(response) {
                var responseObject = Ext.decode(response.responseText);
                this.user = responseObject.data;
                //todo event logIn
            },
            failure: function(response) {
                this.user = null;
                //todo event logOut
            }
        });
    }
});