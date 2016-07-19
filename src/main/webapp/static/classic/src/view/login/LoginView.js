Ext.define('QrAdmin.view.login.LoginView', {
    extend: 'Ext.container.Container',
    xtype: 'loginView',
    controller: 'login',
    requires: [
        'QrAdmin.view.login.LoginController'
    ],
    viewModel: {},

    items: [
        {
            xtype: 'textfield',
            bind: '{login}',
            fieldLabel: 'Username',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            bind: '{password}',
            inputType: 'password',
            fieldLabel: 'Password',
            allowBlank: false
        },
        {
            xtype: 'button',
            text: 'Login',
            listeners: {
                click: 'onLoginButtonClick'
            }
        }
    ]
});