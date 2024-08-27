package com.example.demodynamic

import com.example.demodynamic.properties.RootProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RootProperties::class)
class DemoDynamicApplication

fun main(args: Array<String>) {
    runApplication<DemoDynamicApplication>(*args)
}
