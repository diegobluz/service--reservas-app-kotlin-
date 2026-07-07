package com.company.service.reservas.app.datasources.mappers

import com.company.service.reservas.app.entities.dto.ClienteDTO
import com.company.service.reservas.app.transportlayers.http.request.ClienteRequest
import com.company.service.reservas.app.transportlayers.http.response.ClienteResponse
import org.springframework.stereotype.Component

@Component("clienteTransportMapper")
class ClienteMapper {

    fun clienteDTOTo(dto : ClienteDTO) : ClienteResponse {
        return ClienteResponse().apply {
            this.cliente = dto
        }
    }

    fun requestClientTO(cliente: ClienteRequest): ClienteDTO {
        return ClienteDTO().apply {
            cpf = cliente.cpf
            nomeCompleto = cliente.nomeCompleto
            telefone = cliente.telefone
            email = cliente.email
            dataNascimento = cliente.dataNascimento
            sexo = cliente.sexo
            endereco = cliente.endereco
        }
    }
}