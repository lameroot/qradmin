Ext.define('PayAdmin.view.users.UsersView', {
    extend: 'Ext.panel.Panel',
    xtype: 'usersView',

    requires: [
        'PayAdmin.store.UserStore',
        'PayAdmin.view.users.UsersController'
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
                title: 'Пользователи'
            },
            columns: [
                { text: 'Id',  dataIndex: 'id' },
                { text: 'User name',  dataIndex: 'userName', flex: 1  },
                { text: 'Merchant name', dataIndex: 'merchantName', flex: 1 }
            ]
        }
    ]
});