Ext.define('QrAdmin.view.board.BoardView', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',
    controller: 'board',

    requires: [
        'QrAdmin.view.board.BoardController',
        'QrAdmin.view.users.UsersView',
        'QrAdmin.view.orders.OrdersView',
        'QrAdmin.view.ordertemplates.OrderTemplatesView'
    ],

    ui: 'navigation',
    tabPosition: 'top',
    tabRotation: 0,
    activeTab: 1,
    /*
    header: {
        title: 'QR console',
        bodyPadding: 5,
        items: [
            {
                xtype: 'button',
                text: 'Logout',
                dock: 'right',
                listeners: {
                    click: 'onLogoutButtonClick'
                }
            }
        ]
    },
    */

    items: [
        {
            title: 'Пользователи',
            //iconCls: 'fa-user',
            layout: 'fit',
            items: [
                {
                    xtype: 'usersView'
                }
            ]
        },
        {
            title: 'Заказы',
            //iconCls: 'fa-users',
            layout: 'fit',
            items: [
                {
                    xtype: 'ordersView'
                }
            ]
        },
        {
            title: 'Шаблоны',
            //iconCls: 'fa-users',
            layout: 'fit',
            items: [
                {
                    xtype: 'orderTemplatesView'
                }
            ]
        }
    ]
});
