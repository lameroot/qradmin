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
                bind: '{orderTemplate.id}',
                fieldLabel: 'ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: '{orderTemplate.terminalId}',
                fieldLabel: 'terminal ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: '{orderTemplate.merchantId}',
                fieldLabel: 'merchant ID',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: '{orderTemplate.amount}',
                fieldLabel: 'amount',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: '{orderTemplate.name}',
                fieldLabel: 'name',
                allowBlank: false
            },
            {
                xtype: 'textfield',
                bind: '{orderTemplate.description}',
                fieldLabel: 'description',
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