package com.example.demodynamic

import com.example.demodynamic.runner.Runner
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    properties = [
        "root.bean1-enabled=true",
        "root.bean2-enabled=true",
        "root.bean3-enabled=true",
        "root.bean4-enabled=true",
        "root.bean5-enabled=true",
        "root.bean6-enabled=true",
    ]
)
class AllEnabledTest {
    @Autowired
    private lateinit var runner: Runner

    @Test
    fun contextLoads() {
        runner.run()
    }
}
