Ext.define('QrAdmin.view.main.Main', {
    extend: 'Ext.container.Viewport',
    xtype: 'app-main',
    requires: [
        'QrAdmin.view.login.LoginView',
        'QrAdmin.view.board.Board',
        'QrAdmin.view.main.MainController'
    ],
    controller: 'main',
    layout: 'absolute',
    items: [
        {
            xtype: 'boardView',
            itemId: 'boardView',
            hidden: true
        },
        {
            xtype: 'loginView',
            itemId: 'loginView',
            hidden: true
        }
    ]
});
