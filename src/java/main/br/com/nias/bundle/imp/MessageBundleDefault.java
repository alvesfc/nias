package br.com.nias.bundle.imp;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.com.nias.bundle.IMessageBundle;

/**
 * Classe default que implementa os metodos definidos pela interface
 * {@link IMessageBundle}
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public class MessageBundleDefault implements IMessageBundle {

    private static final long serialVersionUID = 1L;

    protected ResourceBundle resourceBundle;

    public MessageBundleDefault(ResourceBundle resourceBundle) {
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
        return temp.format(arguments);
    }

}
