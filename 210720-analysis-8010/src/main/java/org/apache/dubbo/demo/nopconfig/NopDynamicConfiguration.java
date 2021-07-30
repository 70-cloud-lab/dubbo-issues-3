package org.apache.dubbo.demo.nopconfig;

import org.apache.dubbo.common.config.configcenter.ConfigurationListener;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;

public class NopDynamicConfiguration implements DynamicConfiguration {
    @Override
    public void addListener(String key, String group, ConfigurationListener listener) {
        System.out.println("NOP-----addListener: key=" + key + "; group=" + group);
    }

    @Override
    public void removeListener(String key, String group, ConfigurationListener listener) {
        System.out.println("NOP-----removeListener: key=" + key + "; group=" + group);
    }

    @Override
    public String getConfig(String key, String group, long timeout) throws IllegalStateException {
        System.out.println("NOP-----getConfig: key=" + key + "; group=" + group);
        return null;
    }

    @Override
    public Object getInternalProperty(String key) {
        System.out.println("NOP-----getInternalProperty: key=" + key);
        return null;
    }

    @Override
    public String getProperties(String key, String group, long timeout) throws IllegalStateException {
        System.out.println("NOP-----getProperties: key=" + key + "; group=" + group);
        return null;
    }
}
