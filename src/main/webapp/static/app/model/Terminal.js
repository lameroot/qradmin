Ext.define('PayAdmin.model.Terminal', {
    extend: 'Ext.data.Model',
    xtype: 'terminal',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'number',    name: 'id', persist: false},
        {type: 'string',    name: 'merchantName', persist: false},
        {type: 'number',    name: 'merchantId'},
        {type: 'string',    name: 'authName'},
        {type: 'string',    name: 'authPassword'}
    ],

    proxy: {
        type: 'rest',
        url: 'api/terminal',
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
