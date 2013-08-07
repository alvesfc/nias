package br.com.nias.bundle.external;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;
import br.com.nias.bundle.IMessageBundle;
import br.com.nias.bundle.imp.MessageBundleDefault;
import br.com.nias.bundle.imp.external.BundleMapAggregateExternal;

public class BundleMapAggregateExternalTest {

    private static IBundleMap bundleMap;
    private static final String CONFIG = System.getProperty("user.dir")+"/properties/configuracao.properties";
   
    private static final String DATABASE = System.getProperty("user.dir")+"/properties/database.properties";
    private static final String DB_NAME = "dataBase.name";
    private static final String POROXY = "proxy";

    @BeforeClass
    public static void init() throws IOException {
        Collection<String> fileNames = new ArrayList<String>();
        fileNames.add(CONFIG);
        fileNames.add(DATABASE);
        bundleMap = new BundleMapAggregateExternal(fileNames);
    }

    @Test
    public void testBundleMapConfig() {
        ResourceBundle bundle = bundleMap.getResourseBundle(CONFIG,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleDefault(bundle);
        String expecteds = "10.20.0.1";

        String actuals = msg.getMessage(POROXY);

        Assert.assertEquals(expecteds, actuals);
    }

    @Test
    public void testBundleMapDataBase() {
        ResourceBundle bundle = bundleMap.getResourseBundle(DATABASE,LocaleEnum.DEFAULT);
        IMessageBundle msg = new MessageBundleDefault(bundle);
        String expecteds = "Nome do Banco";

        String actuals = msg.getMessage(DB_NAME);

        Assert.assertEquals(expecteds, actuals);
    }

}
