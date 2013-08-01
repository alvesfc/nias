package br.com.nias.message;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nias.message.imp.TemplateKeyDefault;

public class TemplateKeyTest {
	
	private static ITemplateKey templateKey;
	
	@BeforeClass
	public static void init() {
		templateKey = new TemplateKeyDefault();

	}

	@Test
	public void testGenerateLabelDefault() {
		 String target = "lbl_name";
		 String name = "name";
		 
		 String result = templateKey.generate(name);
		 
		 Assert.assertEquals(target, result);
	}
	
	@Test
	public void testGenerateLabelDefaultWithClass() {
		 String target = "lbl_classname_name";
		 String name = "name";
		 String className = "className";
		 
		 String result = templateKey.generate(className,name);
		 
		 Assert.assertEquals(target, result);
	}

	@Test
	public void testGenerateLabelDefaultParameterNull() {
		 String target = "lbl_null";
		 String name = null;
		 
		 String result = templateKey.generate(name);
		 
		 Assert.assertEquals(target, result);
	}
	
	@Test
	public void testGenerateLabelDefaultWithClassParametersNull() {
		 String target = "lbl_null_null";
		 String name = null;
		 String className = null;
		 
		 String result = templateKey.generate(className,name);
		 
		 Assert.assertEquals(target, result);
	}
	
	@Test
	public void testGenerateLabelDefaultParameterBlank() {
		 String target = "lbl_";
		 String name = "";
		 
		 String result = templateKey.generate(name);
		 
		 Assert.assertEquals(target, result);
	}
	
	@Test
	public void testGenerateLabelDefaultWithClassParametersBlank() {
		 String target = "lbl__";
		 String name = "";
		 String className = "";
		 
		 String result = templateKey.generate(className,name);
		 
		 Assert.assertEquals(target, result);
	}

}
