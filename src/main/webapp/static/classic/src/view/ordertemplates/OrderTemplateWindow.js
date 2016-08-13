Ext.define('QrAdmin.view.ordertemplates.OrderTemplateWindow', {
	extend: 'Ext.window.Window',
	xtype: 'orderTemplatesWindow',

	requires: [
		'QrAdmin.view.ordertemplates.OrderTemplateWindowController'
	],
	controller: 'orderTemplateWindow',
    title: 'Order template',
    width: 300,
    height: 600,
	layout: 'fit',
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
                bind: {value:'{orderTemplate.id}'},
                fieldLabel: 'ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value:'{orderTemplate.terminalId}'},
                fieldLabel: 'terminal ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value:'{orderTemplate.merchantId}'},
                fieldLabel: 'merchant ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value:'{orderTemplate.amount}'},
                fieldLabel: 'amount',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value:'{orderTemplate.name}'},
                fieldLabel: 'name',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: {value:'{orderTemplate.description}'},
                fieldLabel: 'description',
                allowBlank: false
            },
            {
                xtype: 'qrCode',
                bind: {
                    qrText: '{orderTemplate.paymentLink}'
                }
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