package ru.vood.generator.forth.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.generator.forth.prop.GenerationProperties

@Configuration
open class PropertyConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "gen")
    open fun generationProperties() = GenerationProperties()
}