Ext.define('PayAdmin.store.MerchantStore', {
    extend: 'Ext.data.Store',      //TODO доступно только 300 записей, переелать на BufferedStore (combobox их не поддерживает)
    model: 'PayAdmin.model.Merchant',
    alias: 'store.merchant',
    storeId: 'merchant',
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