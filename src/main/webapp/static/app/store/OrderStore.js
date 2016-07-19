Ext.define('QrAdmin.store.OrderStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'QrAdmin.model.Order',
    alias: 'store.order',
    autoLoad: true,
    proxy: {
        type: 'rest',
        url: 'api/order',
        limitParam: 'size',
        startParam: 'fromId',
        extraParams: {
            filter: {}
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
});