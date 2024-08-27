package com.example.demodynamic.config

import com.example.demodynamic.config.Try2.Companion.registerBeanDefinition
import com.example.demodynamic.data.DynamicBean
import com.example.demodynamic.properties.RootProperties
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.BeanFactoryAware
import org.springframework.beans.factory.config.RuntimeBeanReference
import org.springframework.beans.factory.getBean
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanNameGenerator
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar
import org.springframework.core.type.AnnotationMetadata
import org.springframework.stereotype.Component

@Component
class Try3 : ImportBeanDefinitionRegistrar, BeanFactoryAware {
    private var beanFactory: BeanFactory? = null

    override fun registerBeanDefinitions(
        importingClassMetadata: AnnotationMetadata,
        registry: BeanDefinitionRegistry,
        importBeanNameGenerator: BeanNameGenerator
    ) {
        val beanFactory = beanFactory!!
        val properties = beanFactory.getBean<RootProperties>()

        if (properties.bean5Enabled) {
            registry.registerBeanDefinition<DynamicBean>("db5") {
                constructorArgumentValues.addIndexedArgumentValue(1, RuntimeBeanReference("staticBean5"))
            }
        }
        if (properties.bean6Enabled) {
            registry.registerBeanDefinition<DynamicBean>("db6") {
                constructorArgumentValues.addIndexedArgumentValue(1, RuntimeBeanReference("staticBean6"))
            }
        }
    }

    override fun setBeanFactory(beanFactory: BeanFactory) {
        this.beanFactory = beanFactory
    }
}
