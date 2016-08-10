Ext.define('QrAdmin.view.ordertemplates.OrderTemplatesViewController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplatesView',

	onFilterButtonClick: function () {
		var ordersStore = this.getView().down('#orderTemplatesGrid').getStore();
		var filter = this.getView().getViewModel().get('filter');
        ordersStore.getProxy().setExtraParam('filter', Ext.JSON.encode(filter));
        ordersStore.load();
	},

	onResetFilterButtonClick: function () {
        var ordersStore = this.getView().down('#orderTemplatesGrid').getStore();
		this.getView().getViewModel().set('filter', {});
        ordersStore.getProxy().setExtraParam('filter', {});
        ordersStore.load();
    }
});
