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
import br.com.nias.bundle.imp.i18n.BundleMapAggregateI18N;
import br.com.nias.bundle.imp.i18n.MessageBundleI18N;

public class BundleMapI18NAgregateTest {
    private static IBundleMap bundleMap;
    private static final String MESSAGE_PROPERTIES = ConstantBundle.BUSINESS_BUNDLE;
    private static final String CLIENT_MESSAGE = ConstantBundle.CLIENT_BUNDLE;
    private static final String NICKNAME = "lbl_user_nickname";
    private static final String LOGIN = "msg_login_invalido";

    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(MESSAGE_PROPERTIES);
        fileNames.add(CLIENT_MESSAGE);
        bundleMap = new BundleMapAggregateI18N(fileNames);
    }

    @Test
    public void testBundleMapLogDefaultl() {
        ResourceBundle bundle = bundleMap.getResourseBundle(MESSAGE_PROPERTIES,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Usuário e/ou senha inválido, tente novamente.";

        String actuals = msg.getMessage(LOGIN);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapLogEnglishUSA() {
        ResourceBundle bundle = bundleMap.getResourseBundle(MESSAGE_PROPERTIES,LocaleEnum.ENGLISH_USA);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "User and / or password invalid, please try again.";

        String actuals = msg.getMessage(LOGIN);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapLogSpanish() {
        ResourceBundle bundle = bundleMap.getResourseBundle(MESSAGE_PROPERTIES,LocaleEnum.SPANISH);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Usuario y / o contraseña inválida, por favor intente de nuevo.";

        String actuals = msg.getMessage(LOGIN);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapClientDefaultl() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Apelido";

        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapClientEnglishUSA() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE, LocaleEnum.ENGLISH_USA);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Nickname";

        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleClientMapSpanish() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CLIENT_MESSAGE, LocaleEnum.SPANISH);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Apodo";

        String actuals = msg.getMessage(NICKNAME);

        Assert.assertEquals(expecteds, actuals);
    }
    
   
}
