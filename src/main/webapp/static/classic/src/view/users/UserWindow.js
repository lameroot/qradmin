Ext.define('PayAdmin.view.users.UserWindow', {
    extend: 'Ext.window.Window',
    xtype: 'userWindow',

    requires: [
        'PayAdmin.view.users.UserWindowController'
    ],
    controller: 'userWindow',
    title: 'Пользователь',
    width: 300,
    height: 200,
    // layout: 'fit',
    modal: true,
    bodyPadding: 10,
    viewModel: {
        data: {user: {}},
        formulas: {
            isNewUser: function(get) {
                return get('user').phantom
            }
        }
    },
    items: {
        xtype: 'panel',
        items: [
            {
                xtype: 'textfield',
                bind: {value: '{user.userName}'},
                fieldLabel: 'Имя',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {
                    hidden: '{!isNewUser}',
                    value: '{user.password}'
                },
                fieldLabel: 'Пароль',
                allowBlank: false
            },
            {
                xtype: 'combobox',
                bind: {value: '{user.merchantId}'},
                fieldLabel: 'Продавец',
                store: 'merchant',
                displayField: 'name',
                valueField: 'id',
                allowBlank: false
            }
        ]
    },
    buttons: [
        {
            text: 'Save',
            listeners: {
                click: 'onSaveButtonClick'
            }
        },
        {
            text: 'Close',
            listeners: {
                click: 'onCloseButtonClick'
            }
        }
    ]
});