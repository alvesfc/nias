package br.com.nias.message;

/**
 * Interface respnsável em definir os matodos necessários para obter os dados
 * da mensagem.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public interface IMessage {

    /**
     * Metodo respnsável em obter o valor da mensagem
     * 
     * @return String contendo o valor da mensagem.
     */
    String getKey();

    /**
     * Metodo respnsável em obter os parâmetros da mensagem
     * 
     * @return lista de parametros da mensagem.
     */
    Object[] getArguments();

    /**
     * Metodo respnsável em obter a tradução da mensagen de exceção.
     * 
     * @return objeto {@link ITranslate} com a tradução da mensagem.
     */
    ITranslate getTranslation();

}
