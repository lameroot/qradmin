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
                        merchant: user
                    }
                }
            }
        ).show();
    },

    onItemClicked: function(grid, record, item, index) {
        // debugger
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
