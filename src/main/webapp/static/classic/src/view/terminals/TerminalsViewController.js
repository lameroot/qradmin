Ext.define('PayAdmin.view.terminals.TerminalsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.terminalsView',

    requires: [
        'PayAdmin.view.terminals.TerminalWindow'
    ],

    onCreateButtonClick: function() {
        var terminal = Ext.create({
            xtype: 'terminal'
        });
        Ext.create(
            {
                xtype: 'terminalWindow',
                viewModel: {
                    data: {
                        terminal: terminal
                    }
                }
            }
        ).show();
    },

    onItemClicked: function(grid, record, item, index) {
        Ext.create(
            {
                xtype: 'terminalWindow',
                viewModel: {
                    data: {
                        terminal: record
                    }
                }
            }
        ).show();
    }

});
