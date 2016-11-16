Ext.define('PayAdmin.view.ordertemplates.OrderTemplateWindow', {
    extend: 'Ext.window.Window',
    xtype: 'orderTemplatesWindow',

    requires: [
        'PayAdmin.view.ordertemplates.OrderTemplateWindowController'
    ],
    controller: 'orderTemplateWindow',
    title: 'Шаблон',
    width: 300,
    height: 600,
    // layout: 'fit',
    modal: true,
    bodyPadding: 10,
    viewModel: {
        data: {orderTemplate: {}}
    },
    items: {
        xtype: 'panel',
        items: [
            {
                xtype: 'textfield',
                bind: {value: '{orderTemplate.name}'},
                fieldLabel: 'Название',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value: '{orderTemplate.amount}'},
                fieldLabel: 'Сумма',
                allowBlank: false
            },
            {
                xtype: 'combobox',
                bind: {value: '{orderTemplate.terminalId}'},
                fieldLabel: 'Терминал',
                store: 'terminal',
                displayField: 'nameWithMerchant',
                valueField: 'id',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value: '{orderTemplate.description}'},
                fieldLabel: 'Описание',
                allowBlank: false
            },
            {
                layout: 'hbox',
                items: [
                    {
                        xtype: 'qrCode',
                        bind: {
                            qrText: '{orderTemplate.paymentLink}'
                        }
                    },
                    {
                        layout: 'vbox',
                        items: [
                            {
                                xtype: 'button',
                                text: 'copy',
                                margin: 20,
                                width: 70
                            },
                            {
                                xtype: 'button',
                                text: 'print',
                                margin: 20,
                                width: 70
                            }
                        ]
                    }
                ]
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