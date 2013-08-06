package br.com.nias.bundle.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;

public class BundleMapExternal implements IBundleMap, Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, ResourceBundle> resourceBundleMap;
    private Collection<String> fileNames;

    private Properties getProperties(String path) throws IOException {
        Properties prop = new Properties();
        FileInputStream file = null;

        try {
            file = new FileInputStream(path);
            prop.load(file);
        } finally {
            if (file != null) {
                file.close();
            }

        }
        return prop;
    }

    private void createResourceMap() throws IOException {
        this.resourceBundleMap = new HashMap<String, ResourceBundle>();
        for (String fileName : fileNames) {
            resourceBundleMap.put(fileName,
                    new ExternalBundle(this.getProperties(fileName)));
        }
    }

    /**
     * Construtor responsável em criar o Map de ResourceBundle a partir de uma
     * lista de caminhos dos arquivos.
     * 
     * @param fileNames
     *            - Collection contendo os caminhos dos arquivos.
     */
    public BundleMapExternal(Collection<String> fileNames) throws IOException {
        this.fileNames = fileNames;
        this.createResourceMap();
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        return this.resourceBundleMap.get(fileName);
    }

}
