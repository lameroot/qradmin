Ext.define('PayAdmin.model.Statistic', {
    extend: 'Ext.data.Model',
    xtype: 'statistic',
    idProperty: 'id',
    fields: [
        {type: 'int', name: 'id'},
        {type: 'int', name: 'value'},
        {type: 'string', name: 'typefalse'},
        {type: 'int', name: 'merchantId'},
        {type: 'int', name: 'orderTemplateId'},
        {type: 'int', name: 'startTime'},
        {type: 'int', name: 'endTime'}
    ]
});

