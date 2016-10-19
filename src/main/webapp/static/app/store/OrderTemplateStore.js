Ext.define('PayAdmin.store.OrderTemplateStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'PayAdmin.model.OrderTemplate',
    alias: 'store.orderTemplate',
    autoLoad: true,
    autoDestroy: true,
    pageSize: 30,
    leadingBufferZone: 2,
    trailingBufferZone: 2,
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