package br.com.nias.bundle.constant;

/**
 * Classe responsável em armazenar os valores fixos que serão<BR>
 * utilizados nas classes do pacote Bundle.
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public final class ConstantBundle {

    /**
     * Constante com o caminho da pasta onde est· localizado os arquivos<BR>
     * .properties.
     */
    public static final String BUNDLE_PATH = "";
    
    /**
     * Constante com o nome do arquivo de Configuração.
     */
    public static final String CONFIG_BUNDLE =  "config/config";
    
    /**
     * Constante com o nome do arquivo de Configuração do Banco.
     */
    public static final String DATABASE_BUNDLE =  "config/dataBase";

    /**
     * Constante com o nome do arquivo de Log das mensagens.
     */
    public static final String BUSINESS_BUNDLE = BUNDLE_PATH+ "business/LogMessagesBusniess";

    /**
     * Constante com o nome do arquivo que irá armazenar as Labels da camada
     * WEB.
     */
    public static final String CLIENT_BUNDLE = BUNDLE_PATH + "client/ClientMessages";


}
