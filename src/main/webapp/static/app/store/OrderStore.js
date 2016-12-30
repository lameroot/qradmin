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
        paramsAsJson: true,
        actionMethods:  {
            read: 'POST'
        },
        api: {
            read: 'api/order/list'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});