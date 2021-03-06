package br.com.nias.bundle.imp.i18n;

import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.imp.AggregateBundle;
import br.com.nias.util.Utility;

/**
 * Classe que estende  da  {@link BundleMapI18N} e
 * agrega todos os valores dos Arquivos passado no construtor removendo as repetições.
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public class BundleMapAggregateI18N extends BundleMapI18N {

    private static final long serialVersionUID = 1L;
    private Collection<String> fileNames;
    
    public BundleMapAggregateI18N(Collection<String> fileNames) {
        super(fileNames);
        this.fileNames = fileNames;
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        Locale l = LocaleEnum.getLocale(locale);
        return new AggregateBundle(Utility.getBundles(resourceBundleMap, fileNames, locale), l);
    }

}
