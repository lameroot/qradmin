Ext.define('PayAdmin.view.statistics.StatisticsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.statisticsView',

    requires: [
    ],

    onAxisLabelRender: function (axis, label, layoutContext) {
        return label.toFixed(label < 10 ? 1: 0) + '%';
    },

    onSeriesTooltipRender: function (tooltip, record, item) {
        var title = item.series.getTitle();

        tooltip.setHtml(title + ' on ' + record.get('month') + ': ' +
        record.get(item.series.getYField()) + '%');
    },

    onColumnRender: function (v) {
        return v + '%';
    },

    onToggleMarkers: function () {
        var chart = this.lookupReference('chart'),
            seriesList = chart.getSeries(),
            ln = seriesList.length,
            i = 0,
            series;

        for (; i < ln; i++) {
            series = seriesList[i];
            series.setShowMarkers(!series.getShowMarkers());
        }

        chart.redraw();
    },

    onPreview: function () {
        var chart = this.lookupReference('chart');
        chart.preview();
    },

    onRefresh1: function () {
        //var chart = this.getView().down('#chart');
        //var chartStore = chart.getStore();
        var chart = this.getView().down('#chart'),
            chartStore = chart.getStore();

        var fields = ['month', 'data1', 'data2'];
        chartStore.setFields(fields);

        var data =[
            { month: 'Jan', data1: 10, data2: 10},
            { month: 'Feb', data1: 10, data2: 10},
            { month: 'Mar', data1: 9, data2: 10},
            { month: 'Apr', data1: 8, data2: 10},
            { month: 'May', data1: 18, data2: 10},
            { month: 'Jun', data1: 17, data2: 10},
            { month: 'Jul', data1: 16, data2: 10},
            { month: 'Aug', data1: 16, data2: 10},
            { month: 'Sep', data1: 16, data2: 10},
            { month: 'Oct', data1: 16, data2: 10},
            { month: 'Nov', data1: 15, data2: 10},
            { month: 'Dec', data1: 10, data2: 10}
        ];




        var series = [];
        //todo:  не отображается 2 линия(((
        var newSeries = new Ext.chart.series.Line(
            {
            chart: chart,
            type: 'line',
            title: 'IE2',
            xField: 'month',
            yField: 'data2'
        });
        series.push(newSeries);
        chart.series = series;

        chartStore.setData(data);
        debugger;




    },

    onRefresh: function () {
        /*
        var chart = this.getView().down('#chart');
        var chartStore = chart.getStore();

        var templates = ['name', '1','2','3'];

        chartStore.setFields(templates);
        chartStore.getProxy().setExtraParam('filter', Ext.JSON.encode(templates));
        chartStore.load();

        debugger;

        var axes = chart.getAxes();
        axes[0].setFields(['1','2','3'])

        var series = [];
        series.push({
            type: 'line',
            title: 'IE2',
            xField: 'name',
            yField: '1'
        },
            {
                type: 'line',
                title: 'IE2',
                xField: 'name',
                yField: '2'
            },
            {
                type: 'line',
                title: 'IE2',
                xField: 'name',
                yField: '3'
            }

        );

        chart.config.series.push(series);


        chart.redraw();
        //chart.refresh();
        */

    }




});
