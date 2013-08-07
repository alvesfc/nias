package br.com.nias.bundle.imp.external;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.imp.AggregateBundle;
import br.com.nias.util.Utility;

/**
 * Classe que estende  da  {@link BundleMapExternal} e
 * agrega todos os valores dos Arquivos passado no construtor removendo as repetições.
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public class BundleMapAggregateExternal extends BundleMapExternal {

  
    private static final long serialVersionUID = 1L;
    
    public BundleMapAggregateExternal(Collection<String> fileNames)throws IOException {
        super(fileNames);
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        return new AggregateBundle(Utility.getBundles(resourceBundleMap, fileNames));
    }
    
}
