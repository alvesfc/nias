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



public class BundleMapDefaultTest {
	
    private static IBundleMap bundleMap;
    private static final String CONFIG = ConstantBundle.CONFIG_BUNDLE;
    private static final String TEST = "config_test";
    
    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(CONFIG);
        bundleMap = new BundleMapDefault(fileNames);

    }
    
    @Test
    public void testBundleMapDefaultl() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CONFIG,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleDefault(bundle);
        String expecteds = "Linha de configuração";
        String actuals = msg.getMessage(TEST);

        Assert.assertEquals(expecteds, actuals);
    }
    
}

