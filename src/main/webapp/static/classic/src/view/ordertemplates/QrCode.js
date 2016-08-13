Ext.define('QrAdmin.view.ordertemplates.QrCode', {
    extend: 'Ext.Component',
    xtype: 'qrCode',
    config:{
        qrText: null,
        emptyHtml: '<h1>Qr code will be here</h1>'
    },
    initComponent: function () {
        var qrText = this.getQrText();
        debugger
        console.log(qrText);
        var ths = this;
        if (qrText) {
            console.log('1');
            Ext.Loader.loadScript({
                    url: 'external/qrcode.js',
                    onLoad: function () {
                        var qr = qrcode(4, 'M');
                        qr.addData('this is text');
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