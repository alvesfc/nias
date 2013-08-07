package br.com.nias.bundle.i18n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.lombok.i18n.ILocalizable;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.bundle.IMessageBundle;
import br.com.nias.bundle.constant.ConstantBundle;
import br.com.nias.bundle.imp.i18n.BundleMapI18N;
import br.com.nias.bundle.imp.i18n.MessageBundleI18N;

public class MessageBundleI18NTest {
    
    private static IBundleMap bundleMap;
    private static final String LOG_MESSAGE = ConstantBundle.BUSINESS_BUNDLE;
    private static final String CLIENT_MESSAGE = ConstantBundle.CLIENT_BUNDLE;
    private static ResourceBundle bundle;
    private static IMessageBundle msg;
    
    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(LOG_MESSAGE);
        fileNames.add(CLIENT_MESSAGE);
        bundleMap = new BundleMapI18N(fileNames);
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.DEFAULT);

    }
    
    
    @Test
    public void testMessageBundleArguments() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.DEFAULT);
        msg = new MessageBundleI18N(bundle);
        
        String expecteds = "O Campo Apelido não pode ser nulo ou vazio.";
        
        String actuals = msg.getMessage("msg_field_null","lbl_user_nickname");

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testMessageBundleLocale() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.DEFAULT);
        msg = new MessageBundleI18N(bundle);
        ILocalizable localizable = (ILocalizable) msg;
        
        LocaleEnum expecteds = LocaleEnum.DEFAULT;
        
        LocaleEnum actuals = localizable.getLocale();

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testMessageBundleNull() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE,LocaleEnum.DEFAULT);
        msg = new MessageBundleI18N(null);

    }
}
