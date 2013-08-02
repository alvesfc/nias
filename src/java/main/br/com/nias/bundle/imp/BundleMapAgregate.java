

package br.com.nias.bundle.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
public class BundleMapAgregate implements IBundleMap, Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, ResourceBundle> resourceBundleMap;
	private Collection<String> fileNames;

	
	private void createResourceMap() {
		this.resourceBundleMap = new HashMap<String, ResourceBundle>();
		for (String fileName : fileNames) {
			resourceBundleMap.put(fileName,ResourceBundle.getBundle(fileName));
		}
	}
	
	private List<ResourceBundle> getBundles(LocaleEnum locale){
		List<ResourceBundle> bundles =  new ArrayList<ResourceBundle>();
		
		for (String fileName : fileNames) {
			bundles.add(resourceBundleMap.get(fileName));
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
		this.fileNames = fileNames;
		this.createResourceMap();
	}

	@Override
	public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
		return new AggregateBundle(this.getBundles(locale),null);
	}
}
