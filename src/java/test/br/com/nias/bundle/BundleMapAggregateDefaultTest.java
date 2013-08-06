package br.com.nias.bundle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.imp.BundleMapAgregate;
import br.com.nias.bundle.imp.i18n.MessageBundleI18N;



public class BundleMapAggregateDefaultTest {
	
    private static IBundleMap bundleMap;
    private static final String CONFIG = "config/config";
    private static final String DATABASE = "config/dataBase";
    private static final String TEST = "config_test";
    private static final String DB_NAME = "nome_do_banco";
    
    
    
    @BeforeClass
    public static void init() {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(CONFIG);
        fileNames.add(DATABASE);
        bundleMap = new BundleMapAgregate(fileNames);

    }
    
    @Test
    public void testBundleMapConfig() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CONFIG,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Linha de configuração";
        String actuals = msg.getMessage(TEST);

        Assert.assertEquals(expecteds, actuals);
    }
    
    @Test
    public void testBundleMapDB() {
        ResourceBundle bundle = bundleMap.getResourseBundle(DATABASE,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleI18N(bundle);
        String expecteds = "Data Base";
        String actuals = msg.getMessage(DB_NAME);

        Assert.assertEquals(expecteds, actuals);
    }
    
}

