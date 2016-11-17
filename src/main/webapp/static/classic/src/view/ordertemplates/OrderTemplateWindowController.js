Ext.define('PayAdmin.view.ordertemplates.OrderTemplateWindowController', {
	extend: 'Ext.app.ViewController',

	alias: 'controller.orderTemplateWindow',

    onSaveButtonClick: function () {
        var ths = this;
        var orderTemplate = this.getView().getViewModel().get('orderTemplate');
        orderTemplate.save({
            success: function (record) {
                ths.getView().getViewModel().set('orderTemplate', record);
                Ext.Msg.alert('Successful', 'Шаблон сохранен');
            },
            failure: function (record) {
                Ext.Msg.alert('Error', 'Шаблон не сохранен');
            },
            callback: function() {
                Ext.data.StoreManager.lookup('orderTemplate').load();
            }
        });
	},

    onCloseButtonClick: function () {
        this.getView().close();
    },

    onSaveImageButtonClick: function() {
        // var qrCode = this.getView().down('qrCode');
        // var imgHtml = qrCode.html;
        // var regexp = /<img src="(.+)".+/;
        // debugger
    },

    onPrintImageButtonClick: function() {

    },

    saveImage: function () {
        // var imgOrURL;
        // embedImage.src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUA"+
        //     "AAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO"+
        //     "9TXL0Y4OHwAAAABJRU5ErkJggg==";
        // imgOrURL = embedImage;
        // if (typeof imgOrURL == 'object')
        //     imgOrURL = embedImage.src;
        // window.win = open(imgOrURL);
        // setTimeout('win.document.execCommand("SaveAs")', 0);
    }
});
