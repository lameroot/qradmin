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

    onRefresh: function () {
        var chart = this.getView().down('#chart');
        var chartStore = chart.getStore();

        var templates = ['name', '1','2','3'];

        var axes = chart.getAxes();
        axes[0].setFields(['1','2','3'])

        var series = chart.getSeries();
        debugger;
        series.add({
            type: 'line',
            title: 'IE',
            xField: 'name',
            yField: '1'
        });
        series.add({
            type: 'line',
            title: 'IE',
            xField: 'name',
            yField: '2'
        });
        series.add({
            type: 'line',
            title: 'IE',
            xField: 'name',
            yField: '3'
        });

        chartStore.setFields(templates);
        chartStore.getProxy().setExtraParam('filter', Ext.JSON.encode(templates));
        chartStore.load();



        /*
        var chart = this.lookupReference('chart'),
            store = chart.getStore();

        var store = Ext.create('Ext.data.Store',{
            extend      : 'Ext.data.Store',

            proxy: {
                type: 'ajax',
                url: 'api/statistics',
                //extraParams: {
                //    size: 10,
                //    filter: {}
                //},
                reader: {
                    type: 'json',
                    root: 'data'
                }
            },
            autoLoad: false
        });

        Ext.Ajax.request({
            type: 'ajax',
            url: 'api/statistics',
            method: 'GET',
            jsonData: {
                size: 10,
                filter: {}

            },
            success: function(response) {
                var data = Ext.decode(response.responseText);
            },
            failure: function(response){
                Ext.Msg.alert('GascardPay',response);
            }
        });
        */
        //chartStore.refreshData();
    }




});
