Ext.define('QrAdmin.view.ordertemplates.OrderTemplateWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplateWindow',

    onSaveButtonClick: function () {
        var ths = this;
        var orderTemplate = this.getView().getViewModel().get('orderTemplate');
        orderTemplate.save({
            success: function (record) {
                ths.getView().getViewModel().set('orderTemplate', record);
                Ext.Msg.alert('Info', 'Order template saved');
            }
            //TODO unsucccessful  Ext.Msg.alert('Info', 'Order template saved');
        });
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
