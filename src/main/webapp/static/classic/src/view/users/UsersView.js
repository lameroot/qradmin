Ext.define('QrAdmin.view.users.UsersView', {
    extend: 'Ext.panel.Panel',
    xtype: 'usersView',

    requires: [
        'QrAdmin.store.UserStore',
        'QrAdmin.view.users.UsersController'
    ],
    controller: 'users',
    layout: 'border',
    viewModel: {data:{filter: {}}},
    items: [
        {
            xtype: 'gridpanel',
            id: 'usersGrid',
            region: 'center',
            store: {
                type: 'user'
            },
            header: {
                title: 'Пользователи',
                items: [
                    {
                        xtype: 'button',
                        text: 'Создать',
                        dock: 'right',
                        listeners: {
                            click: 'onCreateButtonClick'
                        }
                    }
                ]
            },
            columns: [
                { text: 'Id',  dataIndex: 'id' },
                { text: 'User name',  dataIndex: 'userName', flex: 1  },
                { text: 'Merchant name', dataIndex: 'merchantName', flex: 1 }
            ],
            listeners: {
                itemclick: 'onItemClicked'
            }
        }
    ]
});