package br.com.nias.message.imp;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.message.IMessage;
import br.com.nias.message.ITranslate;

/**
 * Implementação default da interface {@link ITranslate}
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public class DefaultTranslate implements ITranslate {

    private static final long serialVersionUID = 1L;

    private IMessage message;

    public DefaultTranslate(IMessage message) {
        this.message = message;
    }

    @Override
    public String transnlate(LocaleEnum locale) {
        return this.message.getKey();
    }

}
