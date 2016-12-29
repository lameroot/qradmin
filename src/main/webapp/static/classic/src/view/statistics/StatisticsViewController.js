Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
    ],

    onRefreshButtonClick: function () {
        var chart = this.getView().down('#chart');
        chart.setSeries([
            {
                type: 'line',
                xField: 'month',
                yField: 'data1'
            },
            {
                type: 'line',
                xField: 'month',
                yField: 'data2'
            },
            {
                type: 'line',
                xField: 'month',
                yField: 'data3'
            }
        ]);
        var store = chart.getStore();
        store.getProxy().setExtraParam('a1','s1');
        store.getProxy().setExtraParam('a2','s2');
        store.getProxy().setExtraParam('a3', {q1:'r1',q2:'r2'});
        store.load();
    }
});
