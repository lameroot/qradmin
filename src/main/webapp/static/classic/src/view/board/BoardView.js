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
    tabPosition: 'left',
    tabRotation: 0,
    activeTab: 2,
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

    items: [
        {
            title: 'Users',
            iconCls: 'fa-user',
            layout: 'fit',
            items: [
                {
                    xtype: 'usersView'
                }
            ]
        },
        {
            title: 'Orders',
            iconCls: 'fa-users',
            layout: 'fit',
            items: [
                {
                    xtype: 'ordersView'
                }
            ]
        },
        {
            title: 'Order templates',
            iconCls: 'fa-users',
            layout: 'fit',
            items: [
                {
                    xtype: 'orderTemplatesView'
                }
            ]
        }
    ]
});
