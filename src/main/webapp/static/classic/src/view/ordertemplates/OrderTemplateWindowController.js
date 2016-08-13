Ext.define('QrAdmin.view.ordertemplates.OrderTemplateWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplateWindow',

    requires: [
        'QrAdmin.store.OrderTemplateStore'
    ],

    showQrCode: function() {
        // var orderTemplate = this.getView().getViewModel().get('orderTemplate');
        // var qrcode = this.getView().down('#qrcode');
        // var html =
        //     '<div id="qrcode" style="width: 160px; height: 160px;">qrcode</div>' +
        //     '<script type="text/javascript">' +
        //     'debugger;' +
        //     'new QRCode(document.getElementById("qrcode")).makeCode("http://qwe.ddns.net/qrapi/");' +
        //     '</script>';
        // qrcode.update(html, true);
    },

    onSaveButtonClick: function () {
        var ths = this;
        var newOrderTemplate = this.getView().getViewModel().get('orderTemplate');
        newOrderTemplate.save({
            success: function (record) {
                ths.getView().getViewModel().set('orderTemplate', record);
            }
        });
        this.showQrCode();
	},

    onCloseButtonClick: function () {
        this.getView().close();
    }
});
