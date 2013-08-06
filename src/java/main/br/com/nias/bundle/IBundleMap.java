package br.com.nias.bundle;

import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;

/**
 * Interface que define os métodos necessários para manipulação do Map contendo
 * os arquivos properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public interface IBundleMap {

    /**
     * Método responsável em obter um objeto {@link ResourceBundle} contendo os
     * dados do arquivo properties.
     * 
     * @param fileName
     *            - String contendo o nome do arquivo properties.
     * @param locale
     *            - enumerador {@link LocaleEnum} contendo os dados do idioma.
     * @return Objeto {@link ResourceBundle} com os dados do arquivo properties;
     */
    ResourceBundle getResourseBundle(String fileName, LocaleEnum locale);
}
