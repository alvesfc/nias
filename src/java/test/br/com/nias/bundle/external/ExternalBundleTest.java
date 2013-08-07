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
import br.com.nias.bundle.imp.external.BundleMapExternal;

public class ExternalBundleTest {

    private static IBundleMap bundleMap;
    private static final String CONFIG = System.getProperty("user.dir") + "/properties/configuracao.properties";
    private static final String POROXY = "proxy";

    

}
