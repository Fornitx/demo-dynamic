package com.example.demodynamic

import com.example.demodynamic.runner.Runner
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    properties = [
        "root.bean1-enabled=false",
        "root.bean2-enabled=false",
        "root.bean3-enabled=false",
        "root.bean4-enabled=false",
        "root.bean5-enabled=false",
        "root.bean6-enabled=false",
    ]
)
class AllDisasbledTest {
    @Autowired
    private lateinit var runner: Runner

    @Test
    fun contextLoads() {
        runner.run()
    }
}
