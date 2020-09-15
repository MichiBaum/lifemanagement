package com.michibaum.monitoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@SpringBootApplication
@EnableHystrixDashboard
class MonitoringApplication

fun main(args: Array<String>) {
	runApplication<MonitoringApplication>(*args)
}
