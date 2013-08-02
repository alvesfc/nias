package br.com.nias.bundle.imp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import br.com.nias.util.IteratorEnumeration;

class ExternalBundle  extends ResourceBundle {

	private Map<String, Object> contents = new HashMap<String, Object>();
	private Locale locale;

	/**
	 * Creates a new AggregateBundle.
	 * 
	 * @param bundles
	 *            A list of source bundles, which shall be merged into one
	 *            aggregated bundle. The newly created bundle will contain all
	 *            keys from all source bundles. In case a key occurs in multiple
	 *            source bundles, the value will be taken from the first bundle
	 *            containing the key.
	 */
	public ExternalBundle(Properties properties) {
		if (properties != null) {

			Enumeration<Object> keys = properties.keys();
				while (keys.hasMoreElements()) {
					Object oneKey = keys.nextElement();
					if (!contents.containsKey(oneKey)) {
						contents.put((String) oneKey, properties.get(oneKey));
					}
				}
		}
	}

	@Override
	public Enumeration<String> getKeys() {
		return new IteratorEnumeration<String>(contents.keySet().iterator());
	}

	@Override
	protected Object handleGetObject(String key) {
		return contents.get(key);
	}

	@Override
	public Locale getLocale() {
		return this.locale;
	}

	
}
