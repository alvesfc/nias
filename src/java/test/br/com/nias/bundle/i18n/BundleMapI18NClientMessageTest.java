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
import br.com.nias.bundle.constant.ConstantBundle;
import br.com.nias.bundle.imp.i18n.BundleMapI18N;
import br.com.nias.bundle.imp.i18n.MessageBundleI18N;

public class BundleMapI18NClientMessageTest {
    private static IBundleMap bundleMap;
    private static final String CLIENT_MESSAGE =  ConstantBundle.CLIENT_BUNDLE;
    private static final String NICKNAME = "lbl_user_nickname";
    
    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(CLIENT_MESSAGE);
        bundleMap = new BundleMapI18N(fileNames);

    }
    
    @Test
    public void testBundleMapDefaultl() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Apelido";
        
        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testBundleMapEnglishUSA() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE,LocaleEnum.ENGLISH_USA);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Nickname";
        
        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapSpanish() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE,LocaleEnum.SPANISH);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Apodo";

        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }
}
