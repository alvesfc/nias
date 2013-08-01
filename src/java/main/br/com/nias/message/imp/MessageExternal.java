package br.com.nias.message.imp;

import java.io.Serializable;

import br.com.nias.message.IMessage;
import br.com.nias.message.ITranslate;

public class MessageExternal implements IMessage, Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String key;
	private Object[] arguments;
	private ITranslate translate;
	
	public MessageExternal(String key, Object ...args){
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
