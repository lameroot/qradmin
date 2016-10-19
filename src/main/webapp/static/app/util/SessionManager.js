Ext.define('QrAdmin.util.SessionManager', {
    mixins: ['Ext.mixin.Observable'],

    singleton: true,
    authenticated: false,
    alternateClassName: 'SessionManager',
    urls: {
        loginUrl: 'api/security/login',
        logoutUrl: 'api/security/logout',
        userInfoUrl: 'api/info/userInfo'
    },
    userInfo: null,
    
    constructor: function () {
        this.mixins.observable.constructor.call(this);
    },

    isAuthenticated: function () {
        return this.userInfo != null;
    },

    login: function (login, password) {
        var ths = this;
        return new Ext.Promise(function (resolve, reject) {
            Ext.Ajax.request({
                url: ths.urls.loginUrl,
                jsonData: {
                    login: login,
                    password: password
                },
                success: function (response) {
                    var responseObject = Ext.decode(response.responseText);
                    ths.userInfo = responseObject.data;
                    resolve();
                },
                failure: function (response) {
                    var responseObject = Ext.decode(response.responseText);
                    if (responseObject.code == 403) {
                        ths.userInfo = null;
                        resolve();
                        return;
                    }
                    reject();
                }
            });
        });
    },

    logout: function() {
        var ths = this;
        return new Ext.Promise(function (resolve, reject) {
            Ext.Ajax.request({
                url: ths.urls.logoutUrl,
                success: function (response) {
                    ths.userInfo = null;
                    debugger
                    Ext.fireEvent("logoutEvent");
                    resolve();
                },
                failure: function (response) {
                    reject();
                }
            });
        });
    },
    
    updateUserInfo: function () {
        var ths = this;
        return new Ext.Promise(function (resolve, reject) {
            Ext.Ajax.request({
                url: ths.urls.userInfoUrl,
                success: function (response) {
                    var responseObject = Ext.decode(response.responseText);
                    ths.userInfo = responseObject.data;
                    resolve();
                },
                failure: function (response) {
                    reject();
                }
            });
        });
    },

    getUserInfo: function() {
        return this.userInfo;
    },

    hasRole: function(role) {
        return Ext.Array.contains(this.userInfo.roles, role);
    }
});