Ext.define('PayAdmin.util.ModelUtils', {
    singleton: true,
    alternateClassName: 'ModelUtils',

    /**
     * Создает массив из ID элементов стора
     */
    extractItemsIdsFromStore: function (store) {
        var result = [];
        Ext.each(store.getData().items, function (item) {
            result.push(item.id);
        });
        return result;
    }
});