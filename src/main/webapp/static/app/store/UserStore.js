Ext.define('PayAdmin.store.UserStore', {
    extend: 'Ext.data.BufferedStore',
    model: 'PayAdmin.model.User',
    alias: 'store.user',
    storeId: 'user',
    autoLoad: true,
    remoteSort: true,
    remoteFilter: true,
    proxy: {
        type: 'rest',
        url: 'api/user',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});