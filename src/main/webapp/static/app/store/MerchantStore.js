Ext.define('QrAdmin.store.MerchantStore', {
    extend: 'Ext.data.Store',
    model: 'QrAdmin.model.Merchant',
    alias: 'store.merchant',

    sorters: [
        {
            property: 'id',
            direction: 'ASC'
        }
    ],

    autoLoad: true,

    proxy: {
        type: 'rest',
        url: 'api/merchant',
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