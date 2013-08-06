package br.com.nias.bundle.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;

/**
 * Implementacao da interface {@link IBundleMap}.</BR> Esta classe e responsavel
 * por criar o map contendo o caminho para os arquivos properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public class BundleMapAgregate extends BundleMapDefault {

    private static final long serialVersionUID = 1L;

    private transient Map<String, ResourceBundle> resourceBundleMap;
    private Collection<String> fileNames;

    private String getFullPath(String fileName, LocaleEnum locale) {
        return fileName + "_" + locale.getLanguage() + "_"+ locale.getCountry();
    }

    private List<ResourceBundle> getBundles(LocaleEnum locale) {
        List<ResourceBundle> bundles = new ArrayList<ResourceBundle>();

        for (String fileName : fileNames) {
            bundles.add(resourceBundleMap.get(getFullPath(fileName, locale)));
        }

        return bundles;
    }

    /**
     * Construtor responsável em criar o Map de ResourceBundle a partir de uma
     * lista de caminhos dos arquivos.
     * 
     * @param fileNames
     *            - Collection contendo os caminhos dos arquivos.
     */
    public BundleMapAgregate(Collection<String> fileNames) {
        super(fileNames);
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        Locale l = LocaleEnum.getLocale(locale);
        return new AggregateBundle(getBundles(locale), l);
    }

}
