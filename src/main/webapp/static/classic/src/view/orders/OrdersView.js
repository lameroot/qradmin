Ext.define('QrAdmin.view.orders.OrdersView', {
    extend: 'Ext.grid.Panel',
    xtype: 'ordersView',

    requires: [
        'QrAdmin.store.OrderStore',
        'QrAdmin.view.orders.OrdersController'
    ],
    controller: 'orders',

    title: 'Orders',

    store: {
        type: 'order'
    },

    columns: [
        { text: 'orderId',  dataIndex: 'orderId' },
        { text: 'amount',  dataIndex: 'amount', flex: 1  },
        { text: 'deviceId', dataIndex: 'deviceId', flex: 1 }
    ]
});