Ext.define('QrAdmin.store.OrderStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'QrAdmin.model.Order',
    alias: 'store.order',
    autoLoad: true,
    autoDestroy: true,
    pageSize: 30,
    proxy: {
        type: 'rest',
        url: 'api/order',
        extraParams: {
            filter: {}
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});