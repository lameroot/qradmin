Ext.define('PayAdmin.view.merchants.MerchantWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.merchantWindow',

    onSaveButtonClick: function () {
        var ths = this;
        var merchant = this.getView().getViewModel().get('merchant');
        debugger
        merchant.save({
            success: function (record) {
                ths.getView().getViewModel().set('orderTemplate', record);
                Ext.Msg.alert('Успешно', 'Продавец сохранен');
            },
            failure: function (record) {
                Ext.Msg.alert('Ошибка', 'Продавец не сохранен');
            }
        });
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
