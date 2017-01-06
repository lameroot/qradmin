Ext.define('PayAdmin.store.StatisticCalculationTypeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.statisticCalculationType',
    fields: ['display', 'value'],
    data: [
        {display: 'Шаблонам', value: 'BY_TEMPLATES'},
        {display: 'Группам шаблонов', value: 'BY_TEMPLATES_GROUP'},
        {display: 'Терминалам', value: 'BY_TERMINALS'},
        {display: 'Группам терминалов', value: 'BY_TERMINALS_GROUP'}
    ]
});
