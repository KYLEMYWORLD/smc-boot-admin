package com.kyle.data.tenant.autoconfigure;

import com.kyle.data.tenant.configuration.DiscriminatorConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author kyle
 * @date 2024/5/14
 */
@AutoConfiguration
@Import({
        DiscriminatorConfiguration.class
})
public class DataTenantAutoConfiguration {
}
