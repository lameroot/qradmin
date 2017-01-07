Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    onCalculateButtonClick: function () {
        var chart = this.getView().down('#statistics_chart');

        // series, которые будем добавлять (их тип и количество)
        // берем основываясь на том, что выбрал пользователь в браузере
        // например, если он выбрал "показать графики на трех маршутах", то мы добавляем три серии
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

        // здесь проставляем параметры по которым ищем,
        // например,
        // тип интервала (по дням, по часам и т.п.)
        // номера маршрутов
        // все это попадет в StatisticFilterDto вв контроллере
        store.getProxy().setExtraParam('param1', 'qwe');
        store.getProxy().setExtraParam('param2', 'asd');
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
