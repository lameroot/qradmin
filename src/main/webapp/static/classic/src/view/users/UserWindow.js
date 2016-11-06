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
        data: {user: {}}
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
                bind: {value: '{user.merchantName}'},
                fieldLabel: 'Название продавца',
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