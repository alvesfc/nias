package br.com.nias.message;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.message.imp.MessageDefault;

public class MessageDefaultTest {

	@BeforeClass
	public static void init() {

	}

	@Test
	public void testKeyValue() {
		String target = "key";

		String key = "key";
		Object[] args = new Object[] { "a", "b" };

		IMessage message = new MessageDefault(key, args);

		String result = message.getKey();

		Assert.assertEquals(target, result);
	}
	
	@Test
	public void testArgsValue() {
		Object[] target = new Object[] { "a", "b" };
		String key = "key";
		Object[] args = new Object[] { "a", "b" };

		IMessage message = new MessageDefault(key, args);

		Object[] result = message.getArguments();

		Assert.assertArrayEquals(target, result);
	}
	
	@Test
	public void testTranslation() {
		String target = "key";
		String key = "key";

		IMessage message = new MessageDefault(key);

		String result = message.getTranslation().transnlate(LocaleEnum.DEFAULT);

		Assert.assertEquals(target, result);
	}
}
