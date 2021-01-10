package com.chilik1020.mustachepaws.config

import com.chilik1020.mustachepaws.components.AccountValidityInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AppConfig : WebMvcConfigurer {

    @Autowired
    lateinit var accountValidityInterceptor: AccountValidityInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(accountValidityInterceptor)
        super.addInterceptors(registry)
    }

//    override fun addFormatters(registry: FormatterRegistry) {
//        registry.addConverter(StringToAnimalTypeConverter())
//        registry.addConverter(StringToAssistTypeConverter())
//    }
}