Ext.define('QrAdmin.view.merchants.MerchantsView', {
    extend: 'Ext.panel.Panel',
    xtype: 'merchantsView',

    requires: [
        'QrAdmin.store.MerchantStore',
        'QrAdmin.view.merchants.MerchantsController'
    ],
    controller: 'merchants',
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
                            click: 'onCreateButtonClick'
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