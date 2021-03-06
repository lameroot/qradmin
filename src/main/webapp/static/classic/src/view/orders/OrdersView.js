Ext.define('PayAdmin.view.orders.OrdersView', {
	extend: 'Ext.panel.Panel',
	xtype: 'ordersView',

	requires: [
		'PayAdmin.store.OrderStore',
		'PayAdmin.view.orders.OrdersViewController'
	],
	controller: 'ordersView',
	layout: 'border',
	viewModel: {data:{filter: {}}},
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
				{
					xtype: 'fieldset',
					title: 'creation date',
					items: [
						{
							xtype: 'datefield',
							//value: new Date(),
							//margin: '0 20 0 3',
							//disabledDays: [0, 6],
							fieldLabel: 'from',
							bind: '{filter.createdDateFrom}'
						},
						{
							xtype: 'textfield',
							fieldLabel: 'to',
							bind: '{filter.createdDateTo}'
						}
					]
				},
				{
					xtype: 'fieldset',
					title: 'payment date',
					items: [
						{
							xtype: 'textfield',
							fieldLabel: 'from',
							bind: '{filter.paymentDateFrom}'
						},
						{
							xtype: 'textfield',
							fieldLabel: 'to',
							bind: '{filter.paymentDateTo}'
						}
					]
				},
				{
					xtype: 'fieldset',
					title: 'amount',
					items: [
						{
							xtype: 'textfield',
							fieldLabel: 'from',
							bind: '{filter.amountFrom}'
						},
						{
							xtype: 'textfield',
							fieldLabel: 'to',
							bind: '{filter.amountTo}'
						}
					]
				},
				{
					xtype: 'fieldset',
					title: 'params',
					items: [
						{
							xtype: 'textfield',
							fieldLabel: 'order number',
							bind: '{filter.orderNumber}'
						},
						{
							xtype: 'textfield',
							fieldLabel: 'device ID',
							bind: '{filter.deviceID}'
						}
					]
				}
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
			id: 'ordersGrid',
			title: 'Заказы',
			region: 'center',
			store: {
				type: 'order'
			},
			columns: [
				{text: 'ID', dataIndex: 'orderId'},
				{text: 'Сумма', dataIndex: 'amount'},
				{text: 'device ID', dataIndex: 'deviceId'},
				{text: 'Дата создания', dataIndex: 'createdDate', formatter: 'date("H:i:s d.m.Y")'},
				{text: 'Дата оплаты', dataIndex: 'paymentDate', formatter: 'date("H:i:s d.m.Y")'},
				{text: 'Описание', dataIndex: 'description'},
				{text: 'Продавец', dataIndex: 'merchantId'},
				{text: 'Терминал', dataIndex: 'terminalId'},
				{text: 'Клиент', dataIndex: 'clientId'},
				{text: 'integration', dataIndex: 'integrationSupport'},
				{text: 'status', dataIndex: 'orderStatus'},
				{text: 'session ID', dataIndex: 'sessionId'},
				{text: 'secured ', dataIndex: 'paymentSecureType'},
				{text: 'payment way', dataIndex: 'paymentWay'},
				{text: 'payment type', dataIndex: 'paymentType1'}

			]
		}
	]
});