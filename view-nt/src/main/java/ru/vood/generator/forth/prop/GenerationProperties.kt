package ru.vood.generator.forth.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gen")
public class GenerationProperties {
    private String host;
}
