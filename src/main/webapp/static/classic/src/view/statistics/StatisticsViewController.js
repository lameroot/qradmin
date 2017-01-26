Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
        'PayAdmin.util.ModelUtils'
    ],

    onCalculateButtonClick: function () {
        var chart = this.getView().down('#chart');
        var filter = this.getView().getViewModel().get('filter');

        var selectedTerminalsStore = this.getView().down('#terminalsSelector').getStore();
        filter.selectedTerminalsIds = ModelUtils.extractItemsIdsFromStore(selectedTerminalsStore);

        var selectedOrderTemplatesStore = this.getView().down('#orderTemplatesSelector').getStore();
        filter.selectedOrderTemplatesIds = ModelUtils.extractItemsIdsFromStore(selectedOrderTemplatesStore);

        var statisticStore = Ext.create('PayAdmin.store.StatisticStore');
        statisticStore.getProxy().setExtraParam('filter', filter);
        statisticStore.addListener({
            load: this.getStatisticStoreLoadedListener(this.getView())
        });
        statisticStore.load();
    },

    getStatisticStoreLoadedListener: function (view) {
        return function (store, records) {
            var chart = view.down('#chart');

            var chartSeries = [];
            Ext.each(Object.keys(records[0].data.y), function (yField) {
                chartSeries.push({
                    type: 'line',
                    title: yField,
                    xField: 'x',
                    yField: yField,
                    marker: {
                        radius: 4,
                        lineWidth: 2
                    },
                    highlight: {
                        fillStyle: '#000',
                        radius: 5,
                        lineWidth: 2,
                        strokeStyle: '#fff'
                    },
                    tooltip: {
                        trackMouse: true,
                        showDelay: 0,
                        dismissDelay: 0,
                        hideDelay: 0,
                        renderer: function(tooltip, record, item) {
                            tooltip.setHtml(record.get('x') + ' : ' + record.get(yField) );
                        }
                    }
                });
            });
            chart.setSeries(chartSeries);

            var chartStoreData = [];
            Ext.each(records, function (record) {
                var point = record.data.y;
                point.x = record.data.x;
                chartStoreData.push(point);
            });
            chart.getStore().setData(chartStoreData);
        }
    },

    onCalculationTypeSelected: function (combobox, record) {
        var terminalsSelector = this.getView().down('#terminalsSelector');
        var orderTemplatesSelector = this.getView().down('#orderTemplatesSelector');
        var separatelyForTerminalsCheckbox = this.getView().down('#separatelyForTerminalsCheckbox');
        var separatelyForOrderTemplatesCheckbox = this.getView().down('#separatelyForOrderTemplatesCheckbox');

        terminalsSelector.setHidden(true);
        orderTemplatesSelector.setHidden(true);
        separatelyForTerminalsCheckbox.setHidden(true);
        separatelyForOrderTemplatesCheckbox.setHidden(true);

        if (record.data.value == 'BY_TERMINALS') {
            terminalsSelector.setHidden(false);
            separatelyForTerminalsCheckbox.setHidden(false);
        } else if (record.data.value == 'BY_TEMPLATES') {
            orderTemplatesSelector.setHidden(false);
            separatelyForOrderTemplatesCheckbox.setHidden(false);
        }
    },

    onSeriesTooltipRender: function (tooltip, record, item) {
        tooltip.setHtml(record.get('month') + ': ' + record.get('data1') + '%');
    },
});
