Ext.define('PayAdmin.view.merchants.MerchantsViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.merchantsView',

    requires: [
        'PayAdmin.view.merchants.MerchantWindow'
    ],

    onCreateMerchantButtonClick: function() {
        var merchant = Ext.create({
            xtype: 'merchant'
        });
        Ext.create(
            {
                xtype: 'merchantWindow',
                viewModel: {
                    data: {
                        merchant: merchant
                    }
                }
            }
        ).show();
    },

    onItemClicked: function(grid, record, item, index) {
        Ext.create(
            {
                xtype: 'merchantWindow',
                viewModel: {
                    data: {
                        merchant: record
                    }
                }
            }
        ).show();
    }

});
