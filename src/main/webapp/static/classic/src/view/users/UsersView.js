Ext.define('PayAdmin.view.users.UsersView', {
    extend: 'Ext.panel.Panel',
    xtype: 'usersView',

    requires: [
        'PayAdmin.store.UserStore',
        'PayAdmin.view.users.UsersViewController'
    ],
    controller: 'usersView',
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
                { text: 'ID',  dataIndex: 'id' },
                { text: 'Имя',  dataIndex: 'userName', flex: 1  },
                { text: 'Название продавца', dataIndex: 'merchantName', flex: 1 }
            ],
            listeners: {
                itemclick: 'onItemClicked'
            }
        }
    ]
});