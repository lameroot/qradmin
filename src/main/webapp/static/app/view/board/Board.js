Ext.define('QrAdmin.view.board.Board', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',

    requires: [
        'QrAdmin.view.main.MainModel',
        'QrAdmin.view.main.List'
    ],

    viewModel: 'main',

    ui: 'navigation',
    tabPosition: 'left',
    tabRotation: 0,

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            bind: {
                text: '{name}'
            },
            flex: 0
        },
        iconCls: 'fa-th-list'
    },

    items: [
        {
            title: 'Home',
            iconCls: 'fa-home',
            // The following grid shares a store with the classic version's grid as well!
            items: [{
                xtype: 'mainlist'
            }]
        },
        {
            title: 'Users',
            iconCls: 'fa-user',
            bind: {
                html: '{loremIpsum}'
            }
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
