package com.example.conditionalapp.config;

import com.example.conditionalapp.service.DevProfile;
import com.example.conditionalapp.service.ProductionProfile;
import com.example.conditionalapp.service.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
@org.springframework.context.annotation.Configuration
public class Configuration {
    boolean flag;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
