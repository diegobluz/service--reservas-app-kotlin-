package com.company.service.reservas.app.datasources.gateway

import com.company.service.reservas.app.entities.dto.EnderecoDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "cep-gateway", url = "\${service.cep.url}")
interface CepGateway {


    fun validateCep(cep: String): EnderecoDTO

    @GetMapping("/{cep}/json/")
    fun buscarCep(@PathVariable("cep") cep: String): CepData
}


data class CepData(
    val cep: String?,
    val logradouro: String?,
    val complemento: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?,
    val erro: Boolean? = false
)