package br.com.nias.message.imp;

import java.io.Serializable;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.message.ITranslate;

public class DefaultTranslate implements Serializable, ITranslate{


	private static final long serialVersionUID = 1L;

	@Override
	public String transnlate(LocaleEnum locale) {
		return null;
	}

}
