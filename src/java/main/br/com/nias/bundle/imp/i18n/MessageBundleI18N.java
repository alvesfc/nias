package br.com.nias.bundle.imp.i18n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.lombok.i18n.ILocalizable;
import br.com.nias.bundle.imp.MessageBundleDefault;

/**
 * Classe que estende  da  {@link MessageBundleDefault} e
 * implementa a interface {@link ILocalizable} para obter uma string 
 * internacionalizada do arquivo properties.
 * Essa classe irá internacionalizar a chave (Key) e os argumentos (arguments).
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public class MessageBundleI18N extends MessageBundleDefault implements ILocalizable {

    private static final long serialVersionUID = 1L;

    
    public MessageBundleI18N(ResourceBundle resourceBundle) {
        super(resourceBundle);
    }
    
    /**
     * Método que realiza a internacionalização dos Argumentos
     * @param args - Argumentos que serão internacionalizados
     * @return Lista de Argumentos internacionalizados
     */
    private Object[] getArgumentsI18N(Object[] args) {
        Object[] arr = new Object[args.length];
        int i = 0;
        for (Object o : args) {
            arr[i] = this.getMessage(o.toString());
            i++;
        }

        return arr;

    }

    @Override
    public String getMessage(String key, Object... arguments) {
        MessageFormat temp = new MessageFormat(this.getMessage(key));
        return temp.format(this.getArgumentsI18N(arguments));
    }

    @Override
    public LocaleEnum getLocale() {
        return LocaleEnum.getLocale(this.resourceBundle.getLocale());
    }

}
