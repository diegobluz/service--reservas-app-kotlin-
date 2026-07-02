package com.company.service.reservas.app.datasources.gateway

import feign.Response
import com.company.service.reservas.app.entities.dto.EnderecoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "cep-gateway", url = "\${service.cep.url}")
interface CepGateway {

    @GetMapping("/{cep}/json")
    fun getEndereco(@PathVariable("cep") cep: String): EnderecoResponse
}