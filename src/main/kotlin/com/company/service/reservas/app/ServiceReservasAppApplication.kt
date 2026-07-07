package com.company.service.reservas.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@EnableFeignClients
class ServiceReservasAppApplication

fun main(args: Array<String>) {
	runApplication<ServiceReservasAppApplication>(*args)
}
