package br.com.nias.bundle.imp;

import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.util.Utility;

/**
 * Implementação da interface {@link IBundleMap}.</BR> 
 * Esta classe e responsável por criar o map contendo o caminho para os arquivos properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public class BundleMapDefault implements IBundleMap {

    private static final long serialVersionUID = 1L;

    protected Map<String, ResourceBundle> resourceBundleMap;
    

    /**
     * Construtor responsável em criar o Map de ResourceBundle a partir de uma
     * lista de caminhos dos arquivos.
     * 
     * @param fileNames
     *            - Collection contendo os caminhos dos arquivos.
     */
    public BundleMapDefault(Collection<String> fileNames) {
        this.resourceBundleMap = Utility.createResourceMap(fileNames);
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        return this.resourceBundleMap.get(fileName);
    }
}
