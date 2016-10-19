Ext.define('PayAdmin.store.OrderStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'PayAdmin.model.Order',
    alias: 'store.order',
    autoLoad: true,
    autoDestroy: true,
    pageSize: 30,
    leadingBufferZone: 2,
    trailingBufferZone: 2,
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