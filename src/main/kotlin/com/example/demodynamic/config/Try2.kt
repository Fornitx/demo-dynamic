package com.example.demodynamic.config

import com.example.demodynamic.data.DynamicBean
import com.example.demodynamic.properties.RootProperties
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.config.RuntimeBeanReference
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class Try2 {
    @Bean
    fun try22(environment: Environment): BeanDefinitionRegistryPostProcessor {
        return Try22(environment)
    }

    private class Try22(private val environment: Environment) : BeanDefinitionRegistryPostProcessor {
        override fun postProcessBeanDefinitionRegistry(registry: BeanDefinitionRegistry) {
            val properties = Binder.get(environment)
                .bind("root", RootProperties::class.java)
                .get()

            if (properties.bean3Enabled) {
                registry.registerBeanDefinition<DynamicBean>("db3") {
                    constructorArgumentValues.addIndexedArgumentValue(1, RuntimeBeanReference("staticBean3"))
                }
            }
            if (properties.bean4Enabled) {
                registry.registerBeanDefinition<DynamicBean>("db4") {
                    constructorArgumentValues.addIndexedArgumentValue(1, RuntimeBeanReference("staticBean4"))
                }
            }
        }

        override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        }
    }

    companion object {
        inline fun <reified T> BeanDefinitionRegistry.registerBeanDefinition(
            beanName: String,
            configurer: BeanDefinition.() -> Unit
        ) {
            val beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(T::class.java).beanDefinition
            configurer.invoke(beanDefinition)
            registerBeanDefinition(beanName, beanDefinition)
        }
    }
}
