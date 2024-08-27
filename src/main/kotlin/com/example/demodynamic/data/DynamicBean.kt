package com.example.demodynamic.data

import com.example.demodynamic.properties.RootProperties
import com.fasterxml.jackson.databind.ObjectMapper

data class DynamicBean(
    private val objectMapper: ObjectMapper,
    private val staticBean: StaticBean,
    private val properties: RootProperties,
)
