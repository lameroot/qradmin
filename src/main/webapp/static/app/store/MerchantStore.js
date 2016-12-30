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
        paramsAsJson: true,
        actionMethods:  {
            read: 'POST'
        },
        api: {
            read: 'api/merchant/list'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});