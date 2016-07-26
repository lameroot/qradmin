Ext.define('QrAdmin.filter.SerializableFilter', {
	extend: 'Ext.util.Filter',
	alias: 'filter.sfilter',
	serializer: function (result) {
		if (result) {
			result[result.property] = result.value;
			delete result.property;
			delete result.value;
		}
	}	
});
