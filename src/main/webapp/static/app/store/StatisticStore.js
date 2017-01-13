Ext.define('PayAdmin.store.StatisticStore', {
    extend: 'Ext.data.Store',
    model: 'PayAdmin.model.StatisticsPoint',
    alias: 'store.statistic',
    storeId: 'statistic',
    proxy: {
        type: 'rest',
        paramsAsJson: true,
        pageParam: '',
        limitParam: '',
        startParam: '',
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
