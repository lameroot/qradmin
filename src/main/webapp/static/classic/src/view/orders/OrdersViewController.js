Ext.define('QrAdmin.view.orders.OrdersViewController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.ordersView',

    onFilterButtonClick: function () {
        var ordersStore = this.getView().down('#ordersGrid').getStore();
        var filter = this.getView().getViewModel().get('filter');
        for (var filterName in filter) {
            ordersStore.filter(filterName, filter[filterName]);
        }
    },
    
    onResetFilterButtonClick: function () {
        this.getView().getViewModel().set('filter', {});
        this.getView().down('#ordersGrid').getStore().clearFilter();
    }
});
