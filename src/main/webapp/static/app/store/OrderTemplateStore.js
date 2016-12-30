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
        paramsAsJson: true,
        actionMethods:  {
            read: 'POST'
        },
        api: {
            read: 'api/orderTemplate/list'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});