package org.apache.dubbo.demo.nopconfig;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.config.configcenter.AbstractDynamicConfigurationFactory;
import org.apache.dubbo.common.config.configcenter.DynamicConfiguration;

public class NopDynamicConfigurationFactory extends AbstractDynamicConfigurationFactory {
    @Override
    protected DynamicConfiguration createDynamicConfiguration(URL url) {
        return new NopDynamicConfiguration();
    }
}
