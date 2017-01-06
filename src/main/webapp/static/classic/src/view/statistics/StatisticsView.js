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
            // minWidth: 295,
            width: 320,
            items: [
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
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'Расчет по',
                    store: {
                        type: 'statisticCalculationType'
                    },
                    bind: '{filter.calculationType}',
                    queryMode: 'local',
                    displayField: 'display',
                    valueField: 'value',
                    listeners: {
                        select: 'onCalculationTypeSelected'
                    }
                },
                {
                    xtype: 'multiselector',
                    id: 'statistics_terminalsSelector',
                    hidden: true,
                    title: 'Терминалы',
                    bind: '{filter.terminalIds}',
                    fieldName: 'authName',
                    emptyText: 'Терминалы не выбраны. Расчет по всем терминалам.',
                    border: true,
                    search: {
                        field: 'authName',
                        store: {
                            type: 'terminal'
                        }
                    }
                },
                {
                    xtype: 'multiselector',
                    id: 'statistics_orderTemplatesSelector',
                    hidden: true,
                    title: 'Шаблоны',
                    bind: '{filter.orderTemplateIds}',
                    fieldName: 'name',
                    emptyText: 'Шаблоны не выбраны. Расчет по всем шаблонам.',
                    border: true,
                    search: {
                        field: 'name',
                        store: {
                            type: 'orderTemplate'
                        }
                    }
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
                    id: 'statistics_chart',
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