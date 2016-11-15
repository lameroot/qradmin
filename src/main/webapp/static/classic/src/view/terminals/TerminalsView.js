Ext.define('PayAdmin.view.terminals.TerminalsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'terminalsView',

    requires: [
        'PayAdmin.store.TerminalStore',
        'PayAdmin.view.terminals.TerminalsViewController'
    ],
    controller: 'terminalsView',
    layout: 'border',
    viewModel: {data:{filter: {}}},
    items: [
        {
            xtype: 'gridpanel',
            id: 'terminalsGrid',
            region: 'center',
            store: {
                type: 'terminal'
            },
            header: {
                title: 'Терминалы',
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
                { text: 'Имя',  dataIndex: 'authName', flex: 1  },
                { text: 'Название продавца', dataIndex: 'merchantName', flex: 1 }
            ],
            listeners: {
                itemclick: 'onItemClicked'
            }
        }
    ]
});