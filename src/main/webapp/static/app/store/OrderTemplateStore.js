Ext.define('PayAdmin.store.OrderTemplateStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'PayAdmin.model.OrderTemplate',
    alias: 'store.orderTemplate',
    storeId: 'orderTemplate',
    autoLoad: true,
    remoteSort: true,
    remoteFilter: true,
    proxy: {
        type: 'rest',
        url: 'api/orderTemplate',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});