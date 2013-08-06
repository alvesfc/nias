package br.com.nias.bundle.imp;

import java.io.Serializable;
import java.util.ResourceBundle;

import br.com.lombok.enumerator.LocaleEnum;
import br.com.nias.bundle.IBundleMap;

public class MessageBendleExternal implements IBundleMap, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public ResourceBundle getResourseBundle(String fileName, LocaleEnum locale) {
        // TODO Auto-generated method stub
        return null;
    }

}
