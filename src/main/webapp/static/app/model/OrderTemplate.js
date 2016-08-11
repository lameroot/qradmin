Ext.define('QrAdmin.model.OrderTemplate', {
    extend: 'Ext.data.Model',
    xtype: 'orderTemplate',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'int',   name: 'id', persist: false},
        {type: 'int',   name: 'terminalId'},
        {type: 'int',   name: 'merchantId', persist: false},
        {type: 'int',   name: 'amount'},
        {type: 'string',    name: 'name'},
        {type: 'string',    name: 'description'}
    ],

    proxy: {
        type: 'ajax',
        url: 'api/orderTemplate',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});