package br.com.nias.message;

import java.io.Serializable;

/**
 * Interface responsvel em definir os metodos necessarios para gerar o template
 * da chave do arquivo properties.
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public interface ITemplateKey extends Serializable {

    /**
     * Metodo responsável em gerar a chave do arquivo properties no padrão
     * definido
     * 
     * @param name
     *            - String com o nome que ira compor a chave.
     * @return String com o padrao gerado.
     */
    String generate(String name);

    /**
     * Metodo responsãvel em gerar a chave do arquivo properties no padrão
     * definido de acordo com o nome da classe e o valor que ira compor o nome
     * da chave.
     * 
     * @param className
     *            - String com o nome da classe.
     * @param name
     *            - String com o nome que ira compor a chave.
     * @return String com o padrão gerado.
     */
    String generate(String className, String name);

}
