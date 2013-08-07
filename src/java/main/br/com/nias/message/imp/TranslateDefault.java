package br.com.nias.message.imp;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.message.IMessage;
import br.com.nias.message.ITranslation;

/**
 * Implementação default da interface {@link ITranslation}
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public class TranslateDefault implements ITranslation {

    private static final long serialVersionUID = 1L;

    private IMessage message;

    public TranslateDefault(IMessage message) {
        this.message = message;
    }

    @Override
    public String transnlate(LocaleEnum locale) {
        return this.message.getKey();
    }

}
