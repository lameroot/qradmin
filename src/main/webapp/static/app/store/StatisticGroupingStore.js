Ext.define('PayAdmin.store.StatisticGroupingStore', {
    extend: 'Ext.data.Store',
    alias: 'store.statisticGrouping',
    fields: ['display', 'value'],
    data: [
        {display: 'День', value: 'DAY'},
        {display: 'Неделя', value: 'WEEK'},
        {display: 'Месяц', value: 'MONTH'}
    ]
});
