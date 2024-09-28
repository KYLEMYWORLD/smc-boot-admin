package com.kyle.data.tenant.configuration;

import com.kyle.data.tenant.hibernate.DiscriminatorTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kyle
 * @date 2024/5/14
 */
@Configuration(proxyBeanMethods = false)
public class DiscriminatorConfiguration {

    @Bean
    public HibernatePropertiesCustomizer discriminatorTenantIdentifierResolver() {
        return new DiscriminatorTenantIdentifierResolver();
    }
}
