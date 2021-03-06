package br.com.nias.message;

import java.io.Serializable;

import br.com.lombok.enumerator.LocaleEnum;

/**
 * Interface responsável em definir os métodos de tradução das mensagens.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public interface ITranslation extends Serializable{

    /**
     * Método responsável em traduzir a mensagem de acordo com o
     * {@link LocaleEnum}
     * 
     * @param locale
     *            objeto contendo a localização (Linguagem)
     * @return String traduzida.
     */
    String transnlate(LocaleEnum locale);

}
