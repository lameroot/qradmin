Ext.define('PayAdmin.view.ordertemplates.OrderTemplateWindow', {
    extend: 'Ext.window.Window',
    xtype: 'orderTemplatesWindow',

    requires: [
        'PayAdmin.view.ordertemplates.OrderTemplateWindowController'
    ],
    controller: 'orderTemplateWindow',
    title: 'Шаблон',
    width: 300,
    height: 400,
    modal: true,
    bodyPadding: 10,
    viewModel: {
        data: {orderTemplate: {}},
        formulas: {
            paymentLink: function(get) {
                var orderTemplate = get('orderTemplate');
                if (orderTemplate.phantom) {
                    return null;
                }
                return 'https://paystudio.mircloud.host?template=' + orderTemplate.id;//TODO get link from settings CHANGE LINK TO PAYSTUDIO.RU  !!!!!
            },
            isNewOrderTemplate: function(get) {
                return get('orderTemplate').phantom;
            }
        }
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
                bind: {
                    hidden: '{isNewOrderTemplate}'
                },
                items: [
                    {
                        xtype: 'qrCode',
                        bind: {
                            qrText: '{paymentLink}'
                        }
                    },
                    {
                        layout: 'vbox',
                        items: [
                            {
                                xtype: 'button',
                                text: 'Сохранить',
                                margin: 20,
                                width: 70,
                                listeners: {
                                    click: 'onSaveImageButtonClick'
                                }
                            },
                            {
                                xtype: 'button',
                                text: 'Печать',
                                margin: 20,
                                width: 70,
                                listeners: {
                                    click: 'onPrintImageButtonClick'
                                }
                            }
                        ]
                    }
                ]
            }
        ]
    },
    buttons: [
        {
            text: 'Сохранить',
            listeners: {
                click: 'onSaveButtonClick'
            }
        },
        {
            text: 'Закрыть',
            listeners: {
                click: 'onCloseButtonClick'
            }
        }
    ]
});