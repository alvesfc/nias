package br.com.nias.message;



/**
 * Interface responsavel em definir os matodos necessarios para obter os dados
 * da mensagem.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public interface IMessage {

	/**
	 * Metodo responsavel em obter o valor da mensagem
	 * 
	 * @return String contendo o valor da mensagem.
	 */
	public String getKey();

	/**
	 * Metodo responsavel em obter os parametros da mensagem
	 * 
	 * @return lista de parametros da mensagem.
	 */
	public Object[] getArguments();
	
	/**
	 * Metodo responsavel em obter a traducao da mensagen de excecao.
	 * @return objeto {@link ITranslate} com a traducao da mensagem.
	 */
	public ITranslate getTranslation();

	

}
