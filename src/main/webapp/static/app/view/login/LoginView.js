Ext.define('QrAdmin.view.login.LoginView', {
    extend: 'Ext.container.Container',
    xtype: 'loginView',

    items: [{
        xtype: 'textfield',
        name: 'username',
        fieldLabel: 'Username',
        allowBlank: false
    }, {
        xtype: 'textfield',
        name: 'password',
        inputType: 'password',
        fieldLabel: 'Password',
        allowBlank: false
    }, {
        xtype: 'displayfield',
        hideEmptyLabel: false,
        value: 'Enter any non-blank password'
    }]
});