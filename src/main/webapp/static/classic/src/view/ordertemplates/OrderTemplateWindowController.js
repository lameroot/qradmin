Ext.define('QrAdmin.view.ordertemplates.OrderTemplateWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplateWindow',

    onSaveButtonClick: function () {
        var viewModel = this.getView().getViewModel();
	},

    onCloseButtonClick: function () {
    }
});
