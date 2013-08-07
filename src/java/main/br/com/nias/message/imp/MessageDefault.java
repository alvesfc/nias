package br.com.nias.message.imp;

import br.com.nias.message.IMessage;
import br.com.nias.message.ITranslate;

/**
 * Implementação default da interface {@link IMessage}
 * 
 * @author Marcos Alves Cunha
 * @version 1.0
 * 
 */
public class MessageDefault implements IMessage {

    private static final long serialVersionUID = 1L;
    private String key;
    private Object[] arguments;
    private ITranslate translate;

    public MessageDefault(String key, Object... args) {
        this.key = key;
        this.arguments = args;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments.clone();
    }

    @Override
    public ITranslate getTranslation() {
        this.translate = new DefaultTranslate(this);
        return this.translate;
    }
}