package br.com.nias.bundle;


/**
 * Interface que define os metodos necessarios para leitura das mensagens de um
 * determinado arquivo properties.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 */
public interface IMessageBundle {

	/**
	 * Recupera mensagem conforme chave informada.<BR>
	 * O Idioma da mensagem sera o Default da Aplicacao (PT_BR).
	 * 
	 * @param key
	 *            String contendo a chave da mensagem.
	 * @return o texto da mensagem encontrada ou gera excecao caso nao encontre
	 *         a mensagem.
	 */
	public String getMessage(String key);


	/**
	 * Recupera mensagem conforme chave informada e substitui os par‚metros<BR>
	 * que houverem na mensagem.
	 * 
	 * @param key
	 *            String contendo a chave da mensagem.
	 * @param arguments
	 *            lista de parametros para substituicao na mensagem
	 * @return o texto da mensagem encontrada ou gera excecao caso nao encontre
	 *         a mensagem.
	 */
	public String getMessage(String key, Object... arguments);

}
