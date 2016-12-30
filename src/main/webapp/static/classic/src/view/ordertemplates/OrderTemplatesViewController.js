Ext.define('PayAdmin.view.ordertemplates.OrderTemplatesViewController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplatesView',

    requires: [
        'PayAdmin.view.ordertemplates.OrderTemplateWindow',
        'PayAdmin.util.SessionManager'
    ],

	onFilterButtonClick: function () {
		var ordersStore = this.getView().down('#orderTemplatesGrid').getStore();
		var filter = this.getView().getViewModel().get('filter');
        ordersStore.getProxy().setExtraParam('filter', filter);
        ordersStore.load();
	},

	onResetFilterButtonClick: function () {
        var ordersStore = this.getView().down('#orderTemplatesGrid').getStore();
		this.getView().getViewModel().set('filter', {});
        ordersStore.getProxy().setExtraParam('filter', {});
        ordersStore.load();
    },

    onCreateOrderTemplateButtonClick: function() {
        var newOrderTemplate = Ext.create({
            xtype: 'orderTemplate'
        });
        Ext.create(
            {
                xtype: 'orderTemplatesWindow',
                viewModel: {
                    data: {
						orderTemplate: newOrderTemplate,
                        terminalId: SessionManager.getUserInfo().terminalIds[0]
					}
                }
            }
        ).show();
    },

	onItemClicked: function(grid, record, item, index) {
		Ext.create(
			{
				xtype: 'orderTemplatesWindow',
				viewModel: {
					data: {
						orderTemplate: record,
                        terminalId: SessionManager.getUserInfo().terminalIds[0]
					}
				}
			}
		).show();
    }
});
