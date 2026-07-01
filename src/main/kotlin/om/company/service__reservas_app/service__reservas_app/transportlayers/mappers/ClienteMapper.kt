package om.company.service__reservas_app.service__reservas_app.transportlayers.mappers

import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ClienteRequest
import om.company.service__reservas_app.service__reservas_app.transportlayers.response.ClienteResponse

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