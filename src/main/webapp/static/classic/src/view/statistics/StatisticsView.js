Ext.define('PayAdmin.view.statistics.StatisticsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'statisticsView',

    requires: [
        'PayAdmin.view.statistics.StatisticsViewController',
        'PayAdmin.store.StatisticStore'
    ],
    controller: 'statisticsView',
    layout: 'border',
    viewModel: {data:{filter: {}}},
    items: [
        {
            xtype: 'panel',
            id: 'statisticsPanel',
            region: 'center',
            items: [
                {
                    xtype: 'cartesian',
                    id: 'chart',
                    height: 500,
                    store: {
                        type: 'statistic'
                    },
                    axes: [
                        {
                            type: 'numeric',
                            position: 'left',
                            grid: true,
                            minimum: 0
                        },
                        {
                            type: 'category',
                            fields: 'month',
                            position: 'bottom',
                            grid: true
                        }
                    ]
                },
                {
                    xtype: 'button',
                    text: 'Обновить',
                    listeners: {
                        click: 'onRefreshButtonClick'
                    }
                }
            ]
        }
    ]
});