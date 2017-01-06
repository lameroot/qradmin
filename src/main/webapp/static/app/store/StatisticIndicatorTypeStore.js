Ext.define('PayAdmin.store.StatisticIndicatorTypeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.statisticIndicatorType',
    fields: ['display', 'value'],
    data: [
        {display: 'Успешные оплаты', value: 'SUCCESSFUL_PAYMENTS'},
        {display: 'Неуспешные оплаты', value: 'UNSUCCESSFUL_PAYMENTS'},
        {display: 'Денежный оборот', value: 'MONEY'}
    ]
});
