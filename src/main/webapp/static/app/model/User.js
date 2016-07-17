Ext.define('QrAdmin.model.User', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {
            type: 'number',
            persist: false,
            name: 'id'
        },
        {
            type: 'string',
            name: 'userName'
        },
        {
            type: 'string',
            name: 'merchantName'
        },
        {
            type: 'date',
            name: 'createdDate'
        },
        {
            type: 'boolean',
            name: 'isEnabled'
        },
        {
            type: 'boolean',
            name: 'isExpired'
        },
        {
            type: 'boolean',
            name: 'isLocked'
        },
        {
            // type: 'string',
            name: 'roles'
        }
    ],


    proxy: {
        type: 'ajax',
        url: 'api/user',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});
