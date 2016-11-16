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
                bind: {
                    disabled: '{!isNewUser}',
                    value: '{user.userName}'
                },
                fieldLabel: 'Имя',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {
                    value: '{user.password}'
                },
                fieldLabel: 'Пароль'
            },
            {
                xtype: 'combobox',
                bind: {
                    value: '{user.merchantId}'
                },
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