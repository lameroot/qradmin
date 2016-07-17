Ext.define('QrAdmin.view.board.Board', {
    extend: 'Ext.tab.Panel',
    xtype: 'boardView',

    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'QrAdmin.view.main.MainModel',
        'QrAdmin.view.main.List'
    ],

    viewModel: 'main',

    ui: 'navigation',

    tabBarHeaderPosition: 1,
    titleRotation: 0,
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

    tabBar: {
        flex: 1,
        layout: {
            align: 'stretch',
            overflowHandler: 'none'
        }
    },

    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },

    defaults: {
        bodyPadding: 20,
        tabConfig: {
            plugins: 'responsive',
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 120
                }
            }
        }
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
