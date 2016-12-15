Ext.define('PayAdmin.model.Statistic', {
    extend: 'Ext.data.Model',
    xtype: 'statistic',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'int', name: 'id', persist: false},
        {type: 'int', name: 'value', persist: false},
        {type: 'string', name: 'type', persist: false},
        {type: 'int', name: 'merchantId', persist: false},
        {type: 'int', name: 'orderTemplateId', persist: false},
        {type: 'int', name: 'startTime', persist: false},
        {type: 'int', name: 'endTime', persist: false}
    ],

    proxy: {
        type: 'rest',
        url: 'api/statistics',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        },
        actionMethods: {
            create: 'POST',
            update: 'PUT'
        }
    }
});

