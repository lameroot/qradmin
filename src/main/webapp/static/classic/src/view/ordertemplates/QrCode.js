Ext.define('PayAdmin.view.ordertemplates.QrCode', {
    extend: 'Ext.Component',
    xtype: 'qrCode',
    config:{
        qrText: null,
        emptyHtml: '<h1>Qr code will be here</h1>'
    },
    setQrText: function (qrText) {
        this.qrText = qrText;
        var ths = this;
        if (qrText) {
            Ext.Loader.loadScript({
                    url: 'resources/js/qrcode.js',
                    onLoad: function () {
                        var qr = qrcode(4, 'M');
                        qr.addData(ths.qrText);
                        qr.make();
                        var qrCodeTag = qr.createImgTag(4);
                        ths.update(qrCodeTag);
                    }
                }
            );
        } else {
            var qrCodeTag = this.getEmptyHtml();
            ths.update(qrCodeTag);
        }
    }
});