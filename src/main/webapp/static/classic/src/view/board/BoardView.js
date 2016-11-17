Ext.define('PayAdmin.view.board.BoardView', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',
    controller: 'board',

    requires: [
        'PayAdmin.view.board.BoardController',
        'PayAdmin.view.users.UsersView',
        'PayAdmin.view.merchants.MerchantsView',
        'PayAdmin.view.terminals.TerminalsView',
        'PayAdmin.view.orders.OrdersView',
        'PayAdmin.view.ordertemplates.OrderTemplatesView',
        'PayAdmin.view.statistics.StatisticsView'
    ],

    ui: 'navigation',
    tabPosition: 'left',
    tabRotation: 0,
    activeTab: 5,
    header: {
        title: 'PAYstudio',
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
            title: 'Терминалы',
            //iconCls: 'fa-user',
            layout: 'fit',
            plugins: 'access',
            accessFor: ['ADMIN'],
            items: [
                {
                    xtype: 'terminalsView'
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
        },
        {
            title: 'Статистика',
            //iconCls: 'fa-users',
            layout: 'fit',
            items: [
                {
                    xtype: 'statisticsView'
                }
            ]
        }
    ]
});
