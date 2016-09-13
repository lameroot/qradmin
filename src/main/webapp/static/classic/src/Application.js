/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('QrAdmin.Application', {
    extend: 'Ext.app.Application',
    requires: [
        'Ext.app.ViewModel'
    ],

    name: 'QrAdmin',

    stores: [
        // TODO: add global / shared stores here
    ],

    // defaultToken : 'home',
    mainView: 'QrAdmin.view.main.Main',

    launch: function () {
        // TODO - Launch the application
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
