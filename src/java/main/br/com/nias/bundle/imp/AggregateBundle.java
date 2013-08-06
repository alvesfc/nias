package br.com.nias.bundle.imp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.nias.util.IteratorEnumeration;

/**
 * A {@link ResourceBundle} which's content is aggregated from multiple source
 * bundles.
 * <p/> 
 * This class is package-private for the sake of testability.
 * 
 * @author Gunnar Morling
 */
public class AggregateBundle extends ResourceBundle {

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
    public AggregateBundle(List<ResourceBundle> bundles, Locale locale) {
        if (bundles != null) {
            this.locale = locale;
            for (ResourceBundle bundle : bundles) {
                Enumeration<String> keys = bundle.getKeys();
                while (keys.hasMoreElements()) {
                    String oneKey = keys.nextElement();
                    if (!contents.containsKey(oneKey)) {
                        contents.put(oneKey, bundle.getObject(oneKey));
                    }
                }
            }
        }
    }
    
    public AggregateBundle(List<ResourceBundle> bundles) {
        if (bundles != null) {
            for (ResourceBundle bundle : bundles) {
                Enumeration<String> keys = bundle.getKeys();
                while (keys.hasMoreElements()) {
                    String oneKey = keys.nextElement();
                    if (!contents.containsKey(oneKey)) {
                        contents.put(oneKey, bundle.getObject(oneKey));
                    }
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
