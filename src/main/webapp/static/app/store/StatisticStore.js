Ext.define('PayAdmin.store.OrderTemplateStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.Statistic',
    alias: 'store.statistic',
    storeId: 'statistic',
    autoLoad: true,
    remoteSort: true,
    remoteFilter: true,
    proxy: {
        type: 'rest',
        url: 'api/statistics',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});
