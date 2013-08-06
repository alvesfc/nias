package br.com.nias.bundle.imp;

import java.util.Collection;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.util.Utility;

/**
 * Implementacao da interface {@link IBundleMap}.</BR> Esta classe e responsavel
 * por criar o map contendo o caminho para os arquivos properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public class BundleMapAgregate extends BundleMapDefault {

    private static final long serialVersionUID = 1L;

    
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
        return new AggregateBundle(Utility.getBundles(resourceBundleMap, fileNames));
    }

}
