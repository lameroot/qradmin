Ext.define('PayAdmin.view.statistics.StatisticsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'statisticsView',

    requires: [
        'PayAdmin.view.statistics.StatisticsViewController'
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
                    renderTo: document.body,
                    width: 600,
                    height: 400,
                    store: {
                        fields: ['name', 'data1', 'data2', 'data3'],
                        data: [{
                            'name': 1,
                            'data1': 10,
                            'data2': 12,
                            'data3': 14
                        }, {
                            'name': 2,
                            'data1': 7,
                            'data2': 8,
                            'data3': 16
                        }, {
                            'name': 3,
                            'data1': 5,
                            'data2': 2,
                            'data3': 14
                        }, {
                            'name': 7,
                            'data1': 2,
                            'data2': 14,
                            'data3': 6
                        }, {
                            'name': 9,
                            'data1': 27,
                            'data2': 38,
                            'data3': 36
                        }]
                    },
                    axes: [
                        {
                            type: 'numeric',
                            position: 'left',
                            minimum: 0,
                            fields: ['data1', 'data2', 'data3'],
                            title: 'Sample Values',
                            grid: {
                                odd: {
                                    opacity: 1,
                                    fill: '#F2F2F2',
                                    stroke: '#DDD',
                                    'lineWidth': 1
                                }
                            }
                        },
                        {
                            type: 'category',
                            position: 'bottom',
                            title: 'Month of the Year'
                        }
                    ],
                    series: {
                        type: 'area',
                        subStyle: {
                            fill: ['#0A3F50', '#30BDA7', '#96D4C6']
                        },
                        xField: 'name',
                        yField: ['data1', 'data2', 'data3']
                    }
                }
            ]
        }
    ]
});