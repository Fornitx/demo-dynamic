package com.example.demodynamic.config

import com.example.demodynamic.data.DynamicBean
import com.example.demodynamic.data.StaticBean
import com.example.demodynamic.properties.RootProperties
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.getBean
import org.springframework.stereotype.Component

@Component
class Try1 : BeanFactoryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val objectMapper = beanFactory.getBean<ObjectMapper>()
        val staticBean1 = beanFactory.getBean<StaticBean>("staticBean1")
        val staticBean2 = beanFactory.getBean<StaticBean>("staticBean2")
        val properties = beanFactory.getBean<RootProperties>()

        if (properties.bean1Enabled) {
            beanFactory.registerSingleton("db1", DynamicBean(objectMapper, staticBean1, properties))
        }
        if (properties.bean2Enabled) {
            beanFactory.registerSingleton("db2", DynamicBean(objectMapper, staticBean2, properties))
        }
    }
}
