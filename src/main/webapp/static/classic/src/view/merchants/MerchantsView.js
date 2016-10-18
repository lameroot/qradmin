Ext.define('QrAdmin.view.merchants.MerchantsView', {
    extend: 'Ext.grid.Panel',
    xtype: 'merchantsView',

    requires: [
        'QrAdmin.store.MerchantStore',
        'QrAdmin.view.merchants.MerchantsController'
    ],
    controller: 'merchants',

    title: 'Merchants',

    store: {
        type: 'merchant'
    },

    columns: [
        { text: 'Id',  dataIndex: 'id' },
        { text: 'Merchant name',  dataIndex: 'name', flex: 1  },
        { text: 'Description', dataIndex: 'description', flex: 1 }
    ]
});