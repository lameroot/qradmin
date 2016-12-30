Ext.define('PayAdmin.view.ordertemplates.OrderTemplatesView', {
	extend: 'Ext.panel.Panel',
	xtype: 'orderTemplatesView',

	requires: [
		'PayAdmin.store.OrderTemplateStore',
		'PayAdmin.view.ordertemplates.OrderTemplatesViewController'
	],
	controller: 'orderTemplatesView',
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
			id: 'orderTemplatesGrid',
			region: 'center',
			store: {
				type: 'orderTemplate'
			},
            header: {
                title: 'Шаблоны платежей',
                items: [
                    {
                        xtype: 'button',
                        text: 'Создать',
                        dock: 'right',
                        listeners: {
                            click: 'onCreateOrderTemplateButtonClick'
                        }
                    }
                ]
            },
			columns: [
				{text: 'ID', dataIndex: 'id'},
				{text: 'Название', dataIndex: 'name', flex: 1},
				{text: 'Сумма', dataIndex: 'amount', flex: 1},
				{text: 'Описание', dataIndex: 'description', flex: 1},
				{text: 'Терминал', dataIndex: 'terminalName', sortable: false, flex: 1},
				{text: 'Продавец', dataIndex: 'merchantName', sortable: false, flex: 1}
			],
			listeners: {
				itemclick: 'onItemClicked'
			}
		}
	]
});