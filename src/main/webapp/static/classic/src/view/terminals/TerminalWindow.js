Ext.define('PayAdmin.view.terminals.TerminalWindow', {
    extend: 'Ext.window.Window',
    xtype: 'terminalWindow',

    requires: [
        'PayAdmin.view.terminals.TerminalWindowController'
    ],
    controller: 'terminalWindow',
    title: 'Терминал',
    width: 300,
    height: 200,
    // layout: 'fit',
    modal: true,
    bodyPadding: 10,
    viewModel: {
        data: {terminal: {}}
    },
    items: {
        xtype: 'panel',
        items: [
            {
                xtype: 'textfield',
                bind: {value: '{terminal.authName}'},
                fieldLabel: 'Имя',
                allowBlank: false
            },
            {
                xtype: 'combobox',
                bind: {value: '{terminal.merchantId}'},
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