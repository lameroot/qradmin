Ext.define('PayAdmin.view.orders.OrdersViewController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.ordersView',

	onFilterButtonClick: function () {
		var ordersStore = this.getView().down('#ordersGrid').getStore();
		var filter = this.getView().getViewModel().get('filter');
        ordersStore.getProxy().setExtraParam('filter', Ext.JSON.encode(filter));
        ordersStore.load();
	},

	onResetFilterButtonClick: function () {
        var ordersStore = this.getView().down('#ordersGrid').getStore();
		this.getView().getViewModel().set('filter', {});
        ordersStore.getProxy().setExtraParam('filter', {});
        ordersStore.load();
    }
});
