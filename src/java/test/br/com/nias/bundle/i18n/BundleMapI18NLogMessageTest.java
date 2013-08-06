package br.com.nias.bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.BeforeClass;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.lombok.i18n.ILocalizable;
import br.com.nias.bundle.imp.BundleMapI18N;
import br.com.nias.bundle.imp.MessageBundleI18N;


public class BundleMapI18NTest {
	private static IBundleMap bundleMap;
	
	//@BeforeClass
	public static void init(){
		Collection<String> fileNames = new ArrayList<String>();
		fileNames.add("business/LogMessagesBusniess");
		fileNames.add("client/ClientMessages");
		bundleMap = new BundleMapI18N(fileNames);
		
	}
	
	//@Test
	public void getResourseBundleFileNull(){
		ResourceBundle bundle = bundleMap.getResourseBundle("", LocaleEnum.ENGLISH_USA);
		IMessageBundle msg = new MessageBundleI18N(bundle);
		
		System.out.println(msg.getMessage("lbl_user_password"));
		System.out.println(msg.getMessage("msg_login_invalido"));
		
		ILocalizable localize = (ILocalizable) msg;
		System.out.println(localize.getLocale());
	}
}

