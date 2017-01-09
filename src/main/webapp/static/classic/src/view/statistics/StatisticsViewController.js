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

        chart.setSeries([
            {
                type: 'line',
                xField: 'name',
                yField: 'data1'
            },
            {
                type: 'line',
                xField: 'name',
                yField: 'data2'
            }
        ]);
        chart.getStore().setFields(['name', 'data1', 'data2']);
        chart.getStore().setData(
            [{
                'name': 1,
                'data1': 10,
                'data2': 12
            }, {
                'name': 2,
                'data1': 7,
                'data2': 8
            }]
        );
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
    }
});
