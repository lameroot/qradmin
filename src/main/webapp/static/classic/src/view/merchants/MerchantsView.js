Ext.define('PayAdmin.view.merchants.MerchantsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'merchantsView',

    requires: [
        'PayAdmin.store.MerchantStore',
        'PayAdmin.view.merchants.MerchantsViewController'
    ],
    controller: 'merchantsView',
    layout: 'border',
    viewModel: {data:{filter: {}}},
    items: [
        {
            xtype: 'gridpanel',
            id: 'merchantsGrid',
            region: 'center',
            store: {
                type: 'merchant'
            },
            header: {
                title: 'Продавцы',
                items: [
                    {
                        xtype: 'button',
                        text: 'Создать',
                        dock: 'right',
                        listeners: {
                            click: 'onCreateMerchantButtonClick'
                        }
                    }
                ]
            },
            columns: [
                { text: 'Id',  dataIndex: 'id' },
                { text: 'Merchant name',  dataIndex: 'name', flex: 1  },
                { text: 'Description', dataIndex: 'description', flex: 1 }
            ],
            listeners: {
                itemclick: 'onItemClicked'
            }
        }
    ]
});