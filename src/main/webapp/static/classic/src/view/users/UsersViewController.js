Ext.define('PayAdmin.view.users.UsersViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.usersView',

    requires: [
        'PayAdmin.view.users.UserWindow'
    ],

    onCreateButtonClick: function() {
        var user = Ext.create({
            xtype: 'user'
        });
        Ext.create(
            {
                xtype: 'userWindow',
                viewModel: {
                    data: {
                        user: user
                    }
                }
            }
        ).show();
    },

    onItemClicked: function(grid, record, item, index) {
        Ext.create(
            {
                xtype: 'userWindow',
                viewModel: {
                    data: {
                        user: record
                    }
                }
            }
        ).show();
    }

});
