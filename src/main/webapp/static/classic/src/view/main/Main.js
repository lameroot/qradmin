Ext.define('PayAdmin.view.main.Main', {
    extend: 'Ext.container.Viewport',
    xtype: 'app-main',
    requires: [
        'PayAdmin.view.main.MainController'
    ],
    controller: 'main',
    layout: 'fit'
});