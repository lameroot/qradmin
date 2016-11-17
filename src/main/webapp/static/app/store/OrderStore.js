Ext.define('PayAdmin.store.OrderStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'PayAdmin.model.Order',
    alias: 'store.order',
    storeId: 'order',
    autoLoad: true,
    remoteSort: true,
    remoteFilter: true,
    proxy: {
        type: 'rest',
        url: 'api/order',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});