Ext.define('PayAdmin.model.Merchant', {
    extend: 'Ext.data.Model',
    xtype: 'merchant',
    requires: [
        'Ext.data.proxy.Rest'
    ],

    idProperty: 'id',
    fields: [
        {type: 'number',    name: 'id', persist: false},
        {type: 'string',    name: 'name'},
        {type: 'string',    name: 'description'},
        {type: 'date',      name: 'createdDate', persist: false},
        {type: 'string',    name: 'integrationSupport', persist: false},
        // private Set<Long> terminalIds;     //TODO one to many
        // private Set<Long> userIds;
        {type: 'boolean',   name: 'createBinding'}
    ],

    proxy: {
        type: 'ajax',
        url: 'api/merchant',
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'successful'
        }
    }
});
