Ext.define('QrAdmin.view.ordertemplates.OrderTemplatesView', {
	extend: 'Ext.panel.Panel',
	xtype: 'orderTemplatesView',

	requires: [
		'QrAdmin.store.OrderTemplateStore',
		'QrAdmin.view.ordertemplates.OrderTemplatesViewController'
	],
	controller: 'orderTemplatesView',
	layout: 'border',
	viewModel: {filter: {}},
	items: [
		{
			bodyPadding: 5,
			xtype: 'form',
			region: 'east',
			collapsible: true,
			split: true,
			title: 'Filter',
			autoScroll: true,
			layout: {
				type: 'vbox',
				align: 'stretch'
			},
			minWidth: 295,
			items: [
				// {
				// 	xtype: 'fieldset',
				// 	title: 'creation date',
				// 	items: [
				// 		{
				// 			xtype: 'textfield',
				// 			fieldLabel: 'from',
				// 			bind: '{filter.createdDateFrom}'
				// 		},
				// 		{
				// 			xtype: 'textfield',
				// 			fieldLabel: 'to',
				// 			bind: '{filter.createdDateTo}'
				// 		}
				// 	]
				// }
			],
			buttons: [
				{
					text: 'Reset',
					listeners: {
						click: 'onResetFilterButtonClick'
					}
				},
				{
					text: 'Find',
					listeners: {
						click: 'onFilterButtonClick'
					}
				}
			]
		},
		{
			xtype: 'gridpanel',
			id: 'orderTemplatesGrid',
			title: 'Order Templates',
			region: 'center',
			store: {
				type: 'orderTemplate'
			},
			columns: [
				{text: 'ID', dataIndex: 'id'},
                {text: 'terminal ID', dataIndex: 'terminalId'},
                {text: 'merchant ID', dataIndex: 'merchantId'},
                {text: 'amount', dataIndex: 'amount'},
                {text: 'name', dataIndex: 'name'},
                {text: 'description', dataIndex: 'description'}
			]
		}
	]
});