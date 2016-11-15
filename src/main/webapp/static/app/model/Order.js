Ext.define('PayAdmin.model.Order', {
    extend: 'Ext.data.Model',
    xtype: 'order',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'string',    name: 'orderId'},
        {type: 'date',      name: 'createdDate', dateFormat: 'time'},
        {type: 'date',      name: 'paymentDate', dateFormat: 'time'},
        {type: 'int',       name: 'amount'},
        {type: 'string',    name: 'description'},
        {type: 'string',    name: 'deviceId'},
        {type: 'string',    name: 'merchantId'},
        {type: 'string',    name: 'terminalId'},
        {type: 'string',    name: 'clientId'},
        {type: 'string',    name: 'integrationSupport'},
        {type: 'string',    name: 'orderStatus'},
        {type: 'string',    name: 'sessionId'},
        {type: 'string',    name: 'paymentSecureType'},
        {type: 'string',    name: 'paymentWay'},
        {type: 'string',    name: 'paymentType'}
    ],

    proxy: {
        type: 'rest',
        url: 'api/order',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});