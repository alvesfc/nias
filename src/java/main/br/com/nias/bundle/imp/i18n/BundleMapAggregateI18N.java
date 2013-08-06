package br.com.nias.bundle.imp.i18n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.imp.AggregateBundle;

public class BundleMapAggregateI18N extends BundleMapI18N {

    private static final long serialVersionUID = 1L;

    public BundleMapAggregateI18N(Collection<String> fileNames) {
        super(fileNames);
    }

    private List<ResourceBundle> getBundles(LocaleEnum locale) {
        List<ResourceBundle> bundles = new ArrayList<ResourceBundle>();

        for (String fileName : fileNames) {
            bundles.add(resourceBundleMap.get(getFullPath(fileName, locale)));
        }
        return bundles;
    }

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        Locale l = LocaleEnum.getLocale(locale);
        return new AggregateBundle(getBundles(locale), l);
    }

}
