package br.com.nias.bundle.imp.i18n;

import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.util.Utility;

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
     * Construtor responsável em criar o Map de ResourceBundle a partir de uma
     * lista de caminhos dos arquivos.
     * 
     * @param fileNames
     *            - Collection contendo os caminhos dos arquivos.
     */
    public BundleMapI18N(Collection<String> fileNames) {
        this.fileNames = fileNames;
        this.resourceBundleMap = Utility.createResourceMapI18N(fileNames);
    }

    @Override
    public ResourceBundle getResourseBundle(String file, LocaleEnum locale) {
        return Utility.getResourceBundle(file, locale);
    }
}
