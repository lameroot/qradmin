Ext.define('PayAdmin.store.TerminalStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.Terminal',
    alias: 'store.terminal',
    storeId: 'terminal',
    autoLoad: true,
    pageSize: 300,
    sorters: [
        {
            property: 'id',
            direction: 'ASC'
        }
    ],
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