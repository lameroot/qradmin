Ext.define('QrAdmin.view.board.Board', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',

    requires: [
        'QrAdmin.view.main.MainModel',
        'QrAdmin.view.main.List',
        'QrAdmin.view.users.UsersView'
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
                text: 'Logout'
            }
        ]
    },

    items: [
        {
            title: 'Home',
            iconCls: 'fa-home',
            // The following grid shares a store with the classic version's grid as well!
            items: [
                {
                    xtype: 'mainlist'
                }
            ]
        },
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
            title: 'Groups',
            iconCls: 'fa-users',
            bind: {
                html: '{loremIpsum}'
            }
        },
        {
            title: 'Settings',
            iconCls: 'fa-cog',
            bind: {
                html: '{loremIpsum}'
            }
        }
    ]
});
