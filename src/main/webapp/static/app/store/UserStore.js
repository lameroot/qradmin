Ext.define('PayAdmin.store.UserStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.User',
    alias: 'store.user',
    storeId: 'user',

    sorters: [
        {
            property: 'id',
            direction: 'ASC'
        }
    ],

    autoLoad: true,

    proxy: {
        type: 'rest',
        url: 'api/user',
        extraParams: {
            size: 10,
            filter: {}
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});