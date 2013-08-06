package br.com.nias.bundle.i18n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.bundle.IMessageBundle;
import br.com.nias.bundle.imp.i18n.BundleMapI18N;
import br.com.nias.bundle.imp.i18n.MessageBundleI18N;

public class BundleMapI18NLogMessageTest {
    private static IBundleMap bundleMap;
    private static final String LOG_MESSAGE = "business/LogMessagesBusniess";
    private static final String CLIENT_MESSAGE = "client/ClientMessages";
    
    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(LOG_MESSAGE);
        fileNames.add(CLIENT_MESSAGE);
        bundleMap = new BundleMapI18N(fileNames);

    }
    
    @Test
    public void testBundleMapDefaultl() {
        ResourceBundle bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Usuário e/ou senha inválido, tente novamente.";
        
        String actuals = msg.getMessage("msg_login_invalido");

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testBundleMapEnglishUSA() {
        ResourceBundle bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.ENGLISH_USA);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "User and / or password invalid, please try again.";
        
        String actuals = msg.getMessage("msg_login_invalido");

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapSpanish() {
        ResourceBundle bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.SPANISH);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Usuario y / o contraseña inválida, por favor intente de nuevo.";

        String actuals = msg.getMessage("msg_login_invalido");

        Assert.assertEquals(expecteds, actuals);
    }
}
