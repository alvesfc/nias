package br.com.nias.bundle.imp.i18n;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;

/**
 * Implementacção da interface {@link IBundleMap}.</BR> Esta classe responsavel
 * por criar o map contendo o caminho para os arquivos properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public class BundleMapI18N implements IBundleMap {
    private static final long serialVersionUID = 1L;

    protected transient Map<String, ResourceBundle> resourceBundleMap;
    protected Collection<String> fileNames;

    /**
     * Metodo responsavel em obter um {@link ResourceBundle} de acordo com o
     * caminho e o {@link LocaleEnum}.
     * 
     * @param bundlePath
     *            - String contendo o caminho do arquivo.
     * @param locale
     *            objeto contendo a linguagem.
     * @return Objeto encontrado.
     */
    private ResourceBundle getResourceBundle(String bundlePath, LocaleEnum locale) {
        return ResourceBundle.getBundle(bundlePath,LocaleEnum.getLocale(locale));
    }

    protected String getFullPath(String fileName, LocaleEnum locale) {
        return fileName + "_" + locale.getLanguage() + "_" + locale.getCountry();
    }

    private void setFile(String fileName) {

        for (LocaleEnum locale : LocaleEnum.values()) {
            String fullBundlePath = this.getFullPath(fileName, locale);
            ResourceBundle resource = this.getResourceBundle(fullBundlePath,locale);
            resourceBundleMap.put(fullBundlePath, resource);
        }
    }

    private void createResourceMap() {
        this.resourceBundleMap = new HashMap<String, ResourceBundle>();

        for (String fileName : fileNames) {
            this.setFile(fileName);
        }
    }

    /**
     * Construtor responsavel em criar o Map de ResourceBundle a partir de uma
     * lista de caminhos dos arquivos.
     * 
     * @param fileNames
     *            - Collection contendo os caminhos dos arquivos.
     */
    public BundleMapI18N(Collection<String> fileNames) {
        this.fileNames = fileNames;
        this.createResourceMap();
    }

    @Override
    public ResourceBundle getResourseBundle(String file, LocaleEnum locale) {
        return this.getResourceBundle(file, locale);
    }
}