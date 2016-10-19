Ext.define('QrAdmin.plugin.Access', {
    extend: 'Ext.AbstractPlugin',
    alias: 'plugin.access',

    requires: [
        'QrAdmin.util.SessionManager'
    ],

    init: function (target) {
        var userRoles = SessionManager.getUserInfo().roles;
        var targetRoles = target.accessFor;
        var show = Ext.Array.intersect(userRoles, targetRoles).length > 0;
        target.setVisible(show);
    }
});