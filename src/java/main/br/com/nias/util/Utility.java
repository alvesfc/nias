package br.com.nias.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;

/**
 * Classe contendo os métodos utilitários.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public final class Utility {

    
    /**
     * Método responsável em obter um {@link ResourceBundle} de acordo com o
     * caminho e o {@link LocaleEnum}.
     * 
     * @param bundlePath
     *            - String contendo o caminho do arquivo.
     * @param locale
     *            objeto contendo a linguagem.
     * @return Objeto encontrado.
     */
    public static ResourceBundle getResourceBundle(String bundlePath, LocaleEnum locale) {
        return ResourceBundle.getBundle(bundlePath, LocaleEnum.getLocale(locale));
    }
    

    /**
     * Método responsável em criar um {@link Map} com os arquivos ,para internacionalização ,a partir de um nome.
     * 
     * @param fileName - String contendo o nome do arquivo.
     * @return - {@link Map} com os arquivos
     */
    public static Map<String, ResourceBundle> mountResourceBundleMapI18N(String fileName) {
        Map<String, ResourceBundle> resourceBundleMap = new HashMap<String, ResourceBundle>();
        
        for (LocaleEnum locale : LocaleEnum.values()) {
            String fullBundlePath = Utility.getFullPath(fileName, locale);
            ResourceBundle resource = getResourceBundle(fullBundlePath, locale);
            resourceBundleMap.put(fullBundlePath, resource);
        }
        
        return resourceBundleMap;
    }
    
    /**
     * Método responsável em criar um {@link Map} com os arquivos a partir de uma lista de nomes.
     * @param fileNames - lista contendo o nomes dos arquivos.
     * @return - {@link Map} com os arquivos
     */
    public static Map<String, ResourceBundle>  createResourceMapI18N(Collection<String> fileNames) {
        Map<String, ResourceBundle> resourceBundleMap  = new HashMap<String, ResourceBundle>();
        for (String fileName : fileNames) {
            resourceBundleMap.putAll(mountResourceBundleMapI18N(fileName));
        }
        return resourceBundleMap;
    }
    
    
    /**
     * Método responsável em criar um {@link Map} com os arquivos a partir de uma lista de nomes.
     * @param fileNames - lista contendo o nomes dos arquivos.
     * @return - {@link Map} com os arquivos
     */
    public static Map<String, ResourceBundle>  createResourceMap(Collection<String> fileNames) {
        Map<String, ResourceBundle> resourceBundleMap  = new HashMap<String, ResourceBundle>();
        for (String fileName : fileNames) {
            ResourceBundle resource = ResourceBundle.getBundle(fileName);
            resourceBundleMap.put(fileName, resource);
        }
        return resourceBundleMap;
    }
    
    /**
     * Método responsável em obter uma lista de {@link ResourceBundle} de acordo com os parâmetros informados. 
     * @param resourceBundleMap - Objeto {@link Map} contendo os arquivos.
     * @param fileNames - Lista de String com os nomes dos arquivos.
     * @param locale - Objeto {@link LocaleEnum} contedo o idioma.
     * @return - lista de {@link ResourceBundle}
     */
    public static  List<ResourceBundle> getBundles(Map<String, ResourceBundle> resourceBundleMap,Collection<String> fileNames,LocaleEnum locale) {
        List<ResourceBundle> bundles = new ArrayList<ResourceBundle>();

        for (String fileName : fileNames) {
            bundles.add(resourceBundleMap.get(getFullPath(fileName, locale)));
        }
        return bundles;
    }
    
    /**
     * Método responsável em obter uma lista de {@link ResourceBundle} de acordo com os parâmetros informados. 
     * @param resourceBundleMap - Objeto {@link Map} contendo os arquivos.
     * @param fileNames - Lista de String com os nomes dos arquivos.
     * @return - lista de {@link ResourceBundle}
     */
    public static  List<ResourceBundle> getBundles(Map<String, ResourceBundle> resourceBundleMap,Collection<String> fileNames) {
        List<ResourceBundle> bundles = new ArrayList<ResourceBundle>();

        for (String fileName : fileNames) {
            bundles.add(resourceBundleMap.get(fileName));
        }
        return bundles;
    }

    /**
     * Método responsável em obter o caminho completo do arquivo a partir dos parâmetros passado.
     * @param fileName - String contendo o nome do arquivo.
     * @param locale - Objeto {@link LocaleEnum} contedo o idioma.
     * @return - String contendo o caminho completo do arquivo.
     */
    public static String getFullPath(String fileName, LocaleEnum locale) {
        return fileName + "_" + locale.getLanguage() + "_" + locale.getCountry();
    }
}
