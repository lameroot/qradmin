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
        {type: 'string',    name: 'merchantName'},
        {type: 'date',      name: 'createdDate', persist: false},
        {type: 'boolean',   name: 'isEnabled'},
        {type: 'boolean',   name: 'isExpired'},
        {type: 'boolean',   name: 'isLocked'},
        {type: 'string',    name: 'roles'}
    ],


    proxy: {
        type: 'ajax',
        url: 'api/user',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});
