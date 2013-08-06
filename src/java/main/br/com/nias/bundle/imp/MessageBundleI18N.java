package br.com.nias.bundle.imp;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.lombok.i18n.ILocalizable;
import br.com.nias.bundle.IMessageBundle;

/**
 * Classe que implementa as interfaces {@link IMessageBundle} e
 * {@link ILocalizable} para obter uma string internacionalizada do arquivo
 * properties.
 * 
 * @author Marcos Alves
 * @version 1.0
 * 
 */
public class MessageBundleI18N implements IMessageBundle, ILocalizable,
        Serializable {

    private static final long serialVersionUID = 1L;

    private ResourceBundle resourceBundle;

    private Object[] getArgumentsI18N(Object[] args) {
        Object[] arr = new Object[args.length];
        int i = 0;
        for (Object o : args) {
            arr[i] = this.getMessage(o.toString());
            i++;
        }

        return arr;

    }

    public MessageBundleI18N(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public String getMessage(String key) {
        String value;
        try {
            value = resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            value = key;
        }

        return value;
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
