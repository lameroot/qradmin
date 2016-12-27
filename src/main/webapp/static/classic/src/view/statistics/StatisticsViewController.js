Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
    ],

    init: function () {
        var chart = this.getView().down('#chart');
        var store = chart.getStore();
        store.on('load', this.onStoreLoad, this);
    },

    onRefreshButtonClick: function () {
        var chart = this.getView().down('#chart');
        var store = chart.getStore();
        store.load();
    },

    onStoreLoad: function(store, records, successful) {
        var chart = this.getView().down('#chart');
        // chart.setAxes(
        //     [
        //         {
        //             type: 'numeric',
        //             fields: ['data1', 'data2', 'data3'],
        //             position: 'left',
        //             grid: true,
        //             minimum: 0
        //         },
        //         {
        //             type: 'category',
        //             fields: 'month',
        //             position: 'bottom',
        //             grid: true
        //         }
        //     ]
        // );
        // chart.setSeries(
        //     [
        //         {
        //             type: 'line',
        //             xField: 'month',
        //             yField: 'data1'
        //         },
        //         {
        //             type: 'line',
        //             xField: 'month',
        //             yField: 'data2'
        //         },
        //         {
        //             type: 'line',
        //             xField: 'month',
        //             yField: 'data3'
        //         }
        //     ]
        // );
    }
});
