Ext.define('PayAdmin.util.ModelUtils', {
    singleton: true,
    alternateClassName: 'ModelUtils',

    extractItemsIdsFromStore: function (store) {
        var result = [];
        Ext.each(store.getData().items, function (item) {
            result.push(item.id);
        });
        return result;
    }
});