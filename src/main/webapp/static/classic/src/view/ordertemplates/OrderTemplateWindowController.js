Ext.define('QrAdmin.view.ordertemplates.OrderTemplateWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplateWindow',

    onSaveButtonClick: function () {
        var newOrderTemplate = this.getView().getViewModel().get('orderTemplate');
        newOrderTemplate.save();
        this.showQrCode();
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
