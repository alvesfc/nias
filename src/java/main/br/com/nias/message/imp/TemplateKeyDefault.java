package br.com.nias.message.imp;

import org.apache.commons.lang3.StringUtils;

import br.com.nias.message.ITemplateKey;

/**
 * Implementacao default do da intergace {@link ITemplateKey}.</BR>
 * O Prefixo utilizado o <B>lbl_</B>
 * 
 * @author  Marcos Alves
 * @version 1.0
 *
 */
public class TemplateKeyDefault implements ITemplateKey {

	private static final long serialVersionUID = 1L;

	private final String PREFIX = "lbl_";

	@Override
	public String generate(String name)  {
		StringBuilder sb = new StringBuilder();

		sb.append(PREFIX);
		sb.append(name);

		return StringUtils.lowerCase(sb.toString());
	}

	@Override
	public String generate(String className, String name)  {
		StringBuilder sb = new StringBuilder();

		sb.append(PREFIX);
		sb.append(className);
		sb.append("_");
		sb.append(name);

		return StringUtils.lowerCase(sb.toString());
	}

}
