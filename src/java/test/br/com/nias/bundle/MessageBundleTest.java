package br.com.nias.bundle;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.imp.BundleMapDefault;
import br.com.nias.bundle.imp.MessageBundleDefault;

public class MessageBundleTest {

	private static final String CONFIG_DATA_BASE = "config/dataBase";
	private static final String CONFIG = "C:/kepler/Projetos/archipelago/nias/properties/configuracao.properties";
	private static IBundleMap bundleMap;

	@BeforeClass
	public static void init() {
		Collection<String> fileNames = new ArrayList<String>();
		fileNames.add(CONFIG);
		fileNames.add(CONFIG_DATA_BASE);
		bundleMap = new BundleMapDefault(fileNames);

	}

	 @Test
	public void getResourseBundleFileNull() {
		IMessageBundle msg = new MessageBundleDefault(bundleMap.getResourseBundle("", LocaleEnum.ENGLISH_USA));

		System.out.println(msg.getMessage("dataBase.name"));
		System.out.println(msg.getMessage("dataBase.user"));

		URL resUrl = MessageBundleDefault.class.getResource(CONFIG);

		System.out.println(resUrl);
		Properties props = new Properties();
		// props.load( resUrl.openStream() );

	}

	public static void main(String[] args) {
		Properties prop = new Properties();

		try {
			// load a properties file
			prop.load(new FileInputStream(
					"C:/kepler/Projetos/archipelago/nias/properties/configuracao.properties"));

			// get the property value and print it out
			System.out.println(prop.getProperty("dataBase.name"));
			System.out.println(prop.getProperty("dataBase.user"));
			System.out.println(prop.getProperty("dataBase.password"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
