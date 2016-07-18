Ext.define('QrAdmin.view.board.Board', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',
    controller: 'board',

    requires: [
        'QrAdmin.view.board.BoardController',
        'QrAdmin.view.users.UsersView',
        'QrAdmin.view.orders.OrdersView'
    ],

    viewModel: 'main',

    ui: 'navigation',
    tabPosition: 'left',
    tabRotation: 0,

    header: {
        title: {
            bind: {
                text: 'QR console'
            },
            flex: 0
        },
        iconCls: 'fa-th-list',
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
            items: [
                {
                    xtype: 'usersView'
                }
            ]
        },
        {
            title: 'Orders',
            iconCls: 'fa-users',
            items: [
                {
                    xtype: 'ordersView'
                }
            ]
        }
    ]
});
