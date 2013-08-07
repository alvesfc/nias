package br.com.nias.bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.constant.ConstantBundle;
import br.com.nias.bundle.imp.BundleMapDefault;
import br.com.nias.bundle.imp.MessageBundleDefault;

public class MessageBundleDefaultTest {
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
        bundleMap = new BundleMapDefault(fileNames);
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE, LocaleEnum.DEFAULT);

    }

    @Test
    public void testMessageBundleDefault() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE, LocaleEnum.DEFAULT);
        msg = new MessageBundleDefault(bundle);

        String expecteds = "O Campo lbl_user_nickname não pode ser nulo ou vazio.";

        String actuals = msg.getMessage("msg_field_null", "lbl_user_nickname");

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testKeyInvalid() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE, LocaleEnum.DEFAULT);
        msg = new MessageBundleDefault(bundle);

        String expecteds = "msg_key";

        String actuals = msg.getMessage("msg_key");

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testKeyBlank() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE, LocaleEnum.DEFAULT);
        msg = new MessageBundleDefault(bundle);

        String expecteds = "";

        String actuals = msg.getMessage("");

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testKeyNull() {
        bundle = bundleMap.getResourseBundle(LOG_MESSAGE, LocaleEnum.DEFAULT);
        msg = new MessageBundleDefault(bundle);

        String expecteds = null;

        String actuals = msg.getMessage(null);

        Assert.assertEquals(expecteds, actuals);
    }

}