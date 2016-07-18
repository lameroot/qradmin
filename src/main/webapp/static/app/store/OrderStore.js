Ext.define('QrAdmin.store.OrderStore', {
    extend: 'Ext.data.Store',
    model: 'QrAdmin.model.Order',
    alias: 'store.order',

    sorters: [
        // {
        //     property: 'id',
        //     direction: 'ASC'
        // }
    ],

    autoLoad: true,

    proxy: {
        type: 'rest',
        url: 'api/order',
        extraParams: {
            size: 10,
            filter: {}
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});