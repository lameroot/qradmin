Ext.define('PayAdmin.model.User', {
    extend: 'Ext.data.Model',
    xtype: 'user',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'number',    name: 'id', persist: false},
        {type: 'string',    name: 'userName'},
        {type: 'string',    name: 'password'},
        {type: 'string',    name: 'merchantName', persist: false},
        {type: 'number',    name: 'merchantId'},
        {type: 'date',      name: 'createdDate', persist: false}
    ],

    proxy: {
        type: 'rest',
        url: 'api/user',
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
