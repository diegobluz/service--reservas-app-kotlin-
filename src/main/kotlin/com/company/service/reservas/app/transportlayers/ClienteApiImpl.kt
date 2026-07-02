package com.company.service.reservas.app.transportlayers

import com.company.service.reservas.app.interactors.ClienteUseCase
import com.company.service.reservas.app.transportlayers.mappers.ClienteMapper
import com.company.service.reservas.app.transportlayers.request.ClienteRequest
import com.company.service.reservas.app.transportlayers.response.ClienteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/clientes")
class ClienteApiImpl(
    private val clienteUseCase: ClienteUseCase,
    private val mapper: ClienteMapper
) {

    @PostMapping("/create")
    fun createClient(@RequestBody request: ClienteRequest): ResponseEntity<ClienteResponse> {
        val client = mapper.requestClientTO(request)
        val response = mapper.clienteDTOTo(clienteUseCase.execute(client))
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{cpf}")
    fun getClientByCpf(@PathVariable cpf: String): ResponseEntity<ClienteResponse> {
        val clientDto = clienteUseCase.findByCpf(cpf)
            ?: return ResponseEntity.notFound().build() // Retorna 404 caso não exista

        val response = mapper.clienteDTOTo(clientDto)
        return ResponseEntity.ok(response)
    }

}