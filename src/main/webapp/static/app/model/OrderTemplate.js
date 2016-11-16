Ext.define('PayAdmin.model.OrderTemplate', {
    extend: 'Ext.data.Model',
    xtype: 'orderTemplate',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'int', name: 'id', persist: false},
        {type: 'int', name: 'terminalId'},
        {type: 'int', name: 'amount'},
        {type: 'string', name: 'name'},
        {type: 'string', name: 'description'},
        {type: 'string', name: 'terminalName', persist: false},
        {type: 'string', name: 'merchantName', persist: false},
        {type: 'int', name: 'merchantId', persist: false}
    ],

    proxy: {
        type: 'rest',
        url: 'api/orderTemplate',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        },
        actionMethods: {
            create : 'POST',
            update : 'PUT'
        }
    }
});