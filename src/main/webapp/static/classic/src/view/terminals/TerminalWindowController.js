Ext.define('PayAdmin.view.terminals.TerminalWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.terminalWindow',

    onSaveButtonClick: function () {
        var ths = this;
        var terminal = this.getView().getViewModel().get('terminal');
        terminal.save({
            success: function (record) {
                ths.getView().getViewModel().set('terminal', record);
                Ext.Msg.alert('Успешно', 'Терминал сохранен');
            },
            failure: function (record) {
                Ext.Msg.alert('Ошибка', 'Терминал не сохранен');
            },
            callback: function() {
                Ext.data.StoreManager.lookup('terminal').reload();
            }
        });
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
