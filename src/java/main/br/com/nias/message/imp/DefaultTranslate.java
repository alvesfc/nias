package br.com.nias.message.imp;

import java.io.Serializable;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.message.IMessage;
import br.com.nias.message.ITranslate;

public class DefaultTranslate implements Serializable, ITranslate {

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
