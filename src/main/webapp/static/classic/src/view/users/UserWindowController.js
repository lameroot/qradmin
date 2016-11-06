Ext.define('PayAdmin.view.users.UserWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.userWindow',

    onSaveButtonClick: function () {
        var ths = this;
        var merchant = this.getView().getViewModel().get('user');
        merchant.save({
            success: function (record) {
                ths.getView().getViewModel().set('orderTemplate', record);
                Ext.Msg.alert('Успешно', 'Пользователь сохранен');
            },
            failure: function (record) {
                Ext.Msg.alert('Ошибка', 'Пользователь не сохранен');
            }
        });
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
