Ext.define('QrAdmin.view.orders.OrdersView', {
    extend: 'Ext.panel.Panel',
    xtype: 'ordersView',

    requires: [
        'QrAdmin.store.OrderStore',
        'QrAdmin.view.orders.OrdersViewController'
    ],
    controller: 'ordersView',
    layout: 'border',
    viewModel: {filter:{}},
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
                            xtype: 'textfield',
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
                            fieldLabel: 'device ID' ,
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
            title: 'Orders',
            region: 'center',
            store: {
                type: 'order'
            },
            columns: [
                { text: 'order ID',  dataIndex: 'orderId' },
                { text: 'amount',  dataIndex: 'amount', flex: 1  },
                { text: 'device ID', dataIndex: 'deviceId', flex: 1 }
            ]
        }
    ]
});