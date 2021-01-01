package com.chilik1020.mustachepaws.models

import org.springframework.core.convert.converter.Converter

class StringToAnimalTypeConverter : Converter<String?, AnimalType?> {
    override fun convert(source: String): AnimalType {
        return AnimalType.valueOf(source.toUpperCase())
    }
}

class StringToAssistTypeConverter : Converter<String?, AssistanceType?> {
    override fun convert(source: String): AssistanceType {
        return AssistanceType.valueOf(source.toUpperCase())
    }
}