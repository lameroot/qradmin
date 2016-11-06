Ext.define('PayAdmin.view.merchants.MerchantWindow', {
    extend: 'Ext.window.Window',
    xtype: 'merchantWindow',

    requires: [
        'PayAdmin.view.merchants.MerchantWindowController'
    ],
    controller: 'merchantWindow',
    title: 'Продавец',
    width: 300,
    height: 200,
    // layout: 'fit',
    modal: true,
    bodyPadding: 10,
    viewModel: {
        data: {merchant: {}}
    },
    items: {
        xtype: 'panel',
        items: [
            {
                xtype: 'textfield',
                bind: {value: '{merchant.name}'},
                fieldLabel: 'Название',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value: '{merchant.description}'},
                fieldLabel: 'Описание',
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