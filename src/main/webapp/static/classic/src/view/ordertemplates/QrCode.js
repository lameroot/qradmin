Ext.define('QrAdmin.view.ordertemplates.QrCode', {
    extend: 'Ext.Component',
    extend: 'Ext.form.field.Base',
    xtype: 'qrCode',
    config:{
        qrText: 'someText',
        emptyHtml: '<h1>Qr code will be here</h1>'
    },
    click: function () {
        var qrText = this.getQrText();
        this.update(qrText);
    },
    setQrText: function (qrText) {
        this.qrText = qrText;
        var ths = this;
        if (qrText) {
            Ext.Loader.loadScript({
                    url: 'external/qrcode.js',
                    onLoad: function () {
                        var qr = qrcode(4, 'M');
                        qr.addData(qrText);
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