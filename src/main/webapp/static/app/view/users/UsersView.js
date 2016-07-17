Ext.define('QrAdmin.view.users.UsersView', {
    extend: 'Ext.grid.Panel',
    xtype: 'usersView',

    requires: [
        'QrAdmin.store.UserStore',
        'QrAdmin.view.users.UsersController'
    ],
    controller: 'users',

    title: 'Users',

    store: {
        type: 'user'
    },

    columns: [
        { text: 'Id',  dataIndex: 'id' },
        { text: 'User name',  dataIndex: 'userName', flex: 1  },
        { text: 'Merchant name', dataIndex: 'merchantName', flex: 1 }
    ]
});