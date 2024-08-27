package com.example.demodynamic.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("root")
data class RootProperties(
    val bean1Enabled: Boolean,
    val bean2Enabled: Boolean,
    val bean3Enabled: Boolean,
    val bean4Enabled: Boolean,
    val bean5Enabled: Boolean,
    val bean6Enabled: Boolean,
)
