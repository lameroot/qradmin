Ext.define('PayAdmin.store.TerminalStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.Terminal',
    alias: 'store.terminal',
    storeId: 'terminal',

    sorters: [
        {
            property: 'id',
            direction: 'ASC'
        }
    ],

    autoLoad: true,

    proxy: {
        type: 'rest',
        url: 'api/terminal',
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