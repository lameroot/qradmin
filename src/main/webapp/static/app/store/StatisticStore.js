Ext.define('PayAdmin.store.StatisticStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.Statistic',
    alias: 'store.statistic',
    storeId: 'statistic',
    proxy: {
        type: 'rest',
        paramsAsJson: true,
        actionMethods:  {
            read: 'POST'
        },
        url: 'api/statistics',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});
