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
            bodyPadding: 5,
            xtype: 'form',
            region: 'east',
            collapsible: true,
            split: true,
            title: 'Фильтр',
            autoScroll: true,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            minWidth: 295,
            items: [
                {
                    xtype: 'fieldset',
                    title: 'Расчет',
                    items: [
                        {
                            xtype: 'combobox',
                            fieldLabel: 'Расчет по',
                            store: {
                                type: 'statisticCalculationType'
                            },
                            bind: '{filter.calculationType}',
                            queryMode: 'local',
                            displayField: 'display',
                            valueField: 'value'
                        },
                        {
                            xtype: 'multiselector',
                            title: 'Терминалы',
                            fieldName: 'authName',
                            emptyText: 'Терминалы не выбраны. Расчет по всем терминалам.',
                            border: true,
                            search: {
                                field: 'authName',
                                store: {
                                    type: 'terminal'
                                }
                            }
                        }
                    ]
                },
                {
                    xtype: 'fieldset',
                    title: 'Период',
                    items: [
                        {
                            xtype: 'datefield',
                            fieldLabel: 'с',
                            bind: '{filter.dateFrom}'
                        },
                        {
                            xtype: 'datefield',
                            fieldLabel: 'по',
                            bind: '{filter.dateTo}'
                        }
                    ]
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'Группировка',
                    store: {
                        type: 'statisticGrouping'
                    },
                    bind: '{filter.grouping}',
                    queryMode: 'local',
                    displayField: 'display',
                    valueField: 'value'
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'Показатель',
                    store: {
                        type: 'statisticIndicatorType'
                    },
                    bind: '{filter.indicatorType}',
                    queryMode: 'local',
                    displayField: 'display',
                    valueField: 'value'
                }
            ],
            buttons: [
                {
                    text: 'Рассчитать',
                    listeners: {
                        click: 'onCalculateButtonClick'
                    }
                }
            ]
        },
        {
            xtype: 'panel',
            id: 'statisticsPanel',
            region: 'center',
            title: 'Статистика',
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
                }
            ]
        }
    ]
});