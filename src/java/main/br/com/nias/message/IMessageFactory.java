package br.com.nias.message;

/**
 * Interface responsável em definir os métodos para construir/obter uma mensagem.
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public interface IMessageFactory {

	/**
	 * Método responsável em obter um objeto {@link IMessage} com os dados da
	 * mensagem
	 * 
	 * @param args
	 *            - Array com os argumentos para mensagem.
	 * @return objeto {@link IMessage} com os dados da mensagem de log.
	 */
	public IMessage getLogMessage(Object... args);

}
