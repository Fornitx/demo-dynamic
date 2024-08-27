package com.example.demodynamic.config

import com.example.demodynamic.data.StaticBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StaticConfig {
    @Bean
    fun staticBean1(): StaticBean {
        return StaticBean("1")
    }

    @Bean
    fun staticBean2(): StaticBean {
        return StaticBean("2")
    }

    @Bean
    fun staticBean3(): StaticBean {
        return StaticBean("3")
    }

    @Bean
    fun staticBean4(): StaticBean {
        return StaticBean("4")
    }

    @Bean
    fun staticBean5(): StaticBean {
        return StaticBean("5")
    }

    @Bean
    fun staticBean6(): StaticBean {
        return StaticBean("6")
    }
}
