Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
        'PayAdmin.util.ModelUtils'
    ],

    init: function () {
        debugger
        this.getView().down('#chart').getStore().addListener(
            {
                load: this.onChartStoreLoaded(this.getView().down('#chart'))
            }
        );
    },

    onCalculateButtonClick: function () {
        var chart = this.getView().down('#chart');
        var filter = this.getView().getViewModel().get('filter');

        var selectedTerminalsStore = this.getView().down('#terminalsSelector').getStore();
        filter.selectedTerminalsIds = ModelUtils.extractItemsIdsFromStore(selectedTerminalsStore);

        var selectedOrderTemplatesStore = this.getView().down('#orderTemplatesSelector').getStore();
        filter.selectedOrderTemplatesIds = ModelUtils.extractItemsIdsFromStore(selectedOrderTemplatesStore);

        var chartStore = chart.getStore();
        chartStore.getProxy().setExtraParam('filter', filter);
        chartStore.load();
    },

    onChartStoreLoaded: function (chart) {
        return function (store, records, successful) {
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
        };

    },

    onCalculationTypeSelected: function (combobox, record) {
        var terminalsSelector = this.getView().down('#terminalsSelector');
        var orderTemplatesSelector = this.getView().down('#orderTemplatesSelector');

        terminalsSelector.setHidden(true);
        orderTemplatesSelector.setHidden(true);

        if (record.data.value == 'BY_TERMINALS') {
            terminalsSelector.setHidden(false);
        } else if (record.data.value == 'BY_TEMPLATES') {
            orderTemplatesSelector.setHidden(false);
        }
    }
});
