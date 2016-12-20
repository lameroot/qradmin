Ext.define('PayAdmin.view.statistics.StatisticsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'statisticsView',

    requires: [
        'PayAdmin.view.statistics.StatisticsViewController',
        'PayAdmin.store.StatisticStore',
    ],
    controller: 'statisticsView',
    layout: 'border',
    viewModel: {data:{filter: {}}},

    tbar: [
        '->',
        {
            text: 'Refresh',
            handler: 'onRefresh'
        }
    ],
    items: [
        {
            xtype: 'panel',
            id: 'statisticsPanel',
            region: 'center',
            items: [
                //{
                //    xtype: 'cartesian',
                //    renderTo: document.body,
                //    width: 600,
                //    height: 400,
                //    store: {
                //        fields: ['name', 'data1', 'data2', 'data3'],
                //        data: [{
                //            'name': 1,
                //            'data1': 10,
                //            'data2': 12,
                //            'data3': 14
                //        }, {
                //            'name': 2,
                //            'data1': 7,
                //            'data2': 8,
                //            'data3': 16
                //        }, {
                //            'name': 3,
                //            'data1': 5,
                //            'data2': 2,
                //            'data3': 14
                //        }, {
                //            'name': 7,
                //            'data1': 2,
                //            'data2': 14,
                //            'data3': 6
                //        }, {
                //            'name': 9,
                //            'data1': 27,
                //            'data2': 38,
                //            'data3': 36
                //        }]
                //    },
                //    axes: [
                //        {
                //            type: 'numeric',
                //            position: 'left',
                //            minimum: 0,
                //            fields: ['data1', 'data2', 'data3'],
                //            title: 'Sample Values',
                //            grid: {
                //                odd: {
                //                    opacity: 1,
                //                    fill: '#F2F2F2',
                //                    stroke: '#DDD',
                //                    'lineWidth': 1
                //                }
                //            }
                //        },
                //        {
                //            type: 'category',
                //            position: 'bottom',
                //            title: 'Month of the Year'
                //        }
                //    ],
                //    series: {
                //        type: 'area',
                //        subStyle: {
                //            fill: ['#0A3F50', '#30BDA7', '#96D4C6']
                //        },
                //        xField: 'name',
                //        yField: ['data1', 'data2', 'data3']
                //    }
                //}

                {
                    xtype: 'cartesian',
                    id: 'chart',
                    width: '100%',
                    height: 500,
                    legend: {
                        docked: 'right'
                    },
                    store: {
                        type: 'statistic'
                    },
                    /*
                    store: {
                        fields: ['month', 'data1', 'data2', 'data3', 'data4', 'other'],
                        data: [
                            { month: 'Jan', data1: 20, data2: 37, data3: 35, data4: 4, other: 4 },
                            { month: 'Feb', data1: 20, data2: 37, data3: 36, data4: 5, other: 2 },
                            { month: 'Mar', data1: 19, data2: 36, data3: 37, data4: 4, other: 4 },
                            { month: 'Apr', data1: 18, data2: 36, data3: 38, data4: 5, other: 3 },
                            { month: 'May', data1: 18, data2: 35, data3: 39, data4: 4, other: 4 },
                            { month: 'Jun', data1: 17, data2: 34, data3: 42, data4: 4, other: 3 },
                            { month: 'Jul', data1: 16, data2: 34, data3: 43, data4: 4, other: 3 },
                            { month: 'Aug', data1: 16, data2: 33, data3: 44, data4: 4, other: 3 },
                            { month: 'Sep', data1: 16, data2: 32, data3: 44, data4: 4, other: 4 },
                            { month: 'Oct', data1: 16, data2: 32, data3: 45, data4: 4, other: 3 },
                            { month: 'Nov', data1: 15, data2: 31, data3: 46, data4: 4, other: 4 },
                            { month: 'Dec', data1: 15, data2: 31, data3: 47, data4: 4, other: 3 }
                        ]
                    },
                    */
                    insetPadding: 40,

                    axes: [{
                        type: 'numeric',
                        //fields: ['data1', 'data2', 'data3', 'data4'],
                        position: 'left',
                        grid: true,
                        minimum: 0
                    }, {
                        type: 'category',
                        fields: 'name',
                        position: 'bottom',
                        grid: true
                    }],
                    series: [

                    ]
                }
            ]
        }
    ]
});