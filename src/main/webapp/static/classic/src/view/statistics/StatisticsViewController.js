Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
        'PayAdmin.util.ModelUtils'
    ],

    onCalculateButtonClick: function () {
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

        var selectedOrderTemplatesStore = this.getView().down('#orderTemplatesSelector').getStore();
        var selectedOrderTemplates = ModelUtils.extractItemsIdsFromStore(selectedOrderTemplatesStore);
        store.getProxy().setExtraParam('orderTemplates', selectedOrderTemplates);

        var selectedTerminalsStore = this.getView().down('#terminalsSelector').getStore();
        var selectedTerminals = ModelUtils.extractItemsIdsFromStore(selectedTerminalsStore);
        store.getProxy().setExtraParam('selectedTerminals', selectedTerminals);

        var filter = this.getView().getViewModel().get('filter');
        store.getProxy().setExtraParam('dateFrom', filter.dateFrom);
        store.getProxy().setExtraParam('dateTo', filter.dateTo);
        store.getProxy().setExtraParam('grouping', filter.grouping);
        store.getProxy().setExtraParam('indicatorType', filter.indicatorType);

        store.load();
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
