Ext.define('QrAdmin.store.OrderStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'QrAdmin.model.Order',
    alias: 'store.order',
    autoLoad: true,
    autoDestroy: true,
    pageSize: 30,
    remoteSort: true,
    remoteFilter: true,
    proxy: {
        type: 'rest',
        url: 'api/order',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});