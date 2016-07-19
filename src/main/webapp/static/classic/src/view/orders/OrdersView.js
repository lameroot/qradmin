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
//
// private String orderId;
// private Date createdDate;
// private Date paymentDate;
// private long amount;
// private String description;
// private String deviceId;
// private long merchantId;
// private long terminalId;
// private Long clientId;
// private IntegrationSupport integrationSupport;
// private OrderStatus orderStatus = OrderStatus.REGISTERED;
// private String sessionId;
// private PaymentSecureType paymentSecureType;
// private PaymentWay paymentWay;
// private PaymentType paymentType;