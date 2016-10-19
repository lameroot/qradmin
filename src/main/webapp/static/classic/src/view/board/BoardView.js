Ext.define('QrAdmin.view.board.BoardView', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',
    controller: 'board',

    requires: [
        'QrAdmin.view.board.BoardController',
        'QrAdmin.view.users.UsersView',
        'QrAdmin.view.merchants.MerchantsView',
        'QrAdmin.view.orders.OrdersView',
        'QrAdmin.view.ordertemplates.OrderTemplatesView'
    ],

    ui: 'navigation',
    tabPosition: 'left',
    tabRotation: 0,
    activeTab: 1,
    header: {
        title: 'QR console',
        padding: '0 50 0 0',
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
            title: 'Продавцы',
            //iconCls: 'fa-user',
            layout: 'fit',
            plugins: 'access',
            accessFor: ['ADMIN'],
            items: [
                {
                    xtype: 'merchantsView'
                }
            ]
        },
        {
            title: 'Пользователи',
            //iconCls: 'fa-user',
            layout: 'fit',
            plugins: 'access',
            accessFor: ['ADMIN'],
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
