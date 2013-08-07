package br.com.nias.bundle.imp;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.nias.util.IteratorEnumeration;

/**
 * Classe que estende {@link ResourceBundle}.</BR> Esta classe é responsável por
 * agrupar vários {@link ResourceBundle} eliminado as chaves duplicadas.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public class AggregateBundle extends ResourceBundle {

    private Map<String, Object> contents = new HashMap<String, Object>();
    private Locale locale;

    /**
     * Criando um novo AggregateBundle.
     * 
     * @param bundles
     *            Lista de bundles que irá realizar o merge.
     *@param locale
     *            {@link Locale} contendo o idioma.
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

    /**
     * Criando um novo AggregateBundle.
     * 
     * @param bundles
     *            Lista de bundles que irá realizar o merge.
     */
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
