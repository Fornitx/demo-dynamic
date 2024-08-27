package com.example.demodynamic.runner

import com.example.demodynamic.data.DynamicBean
import com.example.demodynamic.properties.RootProperties
import kotlinx.coroutines.Runnable
import org.springframework.beans.factory.getBean
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class Runner(
    private val map: Map<String, DynamicBean>,
    private val context: ConfigurableApplicationContext
) : Runnable {
    override fun run() {
        println(context.getBean<RootProperties>())

        println(map.size)
        map.forEach { (beanName, bean) ->
            println("$beanName - $bean")
        }

        println("Done.")
    }
}
