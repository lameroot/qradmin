Ext.define('QrAdmin.view.login.LoginView', {
    extend: 'Ext.container.Container',
    xtype: 'loginView',
    controller: 'login',
    requires: [
        'QrAdmin.view.login.LoginController'
    ],
    viewModel: {
        data: {}
    },
    layout: 'ux.center',

    items: {
        xtype: 'container',
        items: [
            {
                xtype: 'textfield',
                bind: '{login}',
                fieldLabel: 'Username',
                allowBlank: false,
                listeners: {
                    afterrender: function(field) {
                        field.focus(false, 1000);
                    }
                }
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
    }
});