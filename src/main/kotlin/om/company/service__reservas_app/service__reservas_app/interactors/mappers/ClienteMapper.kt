package om.company.service__reservas_app.service__reservas_app.interactors.mappers

import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ClienteRequest
import om.company.service__reservas_app.service__reservas_app.transportlayers.response.ClienteResponse
import org.springframework.stereotype.Component

@Component
class ClienteMapper {



    companion object {
        fun mapper(dto: ClienteDTO, cpf: String) : ClienteDTO {
            return ClienteDTO(

                cpf = cpf,
                nomeCompleto = dto.nomeCompleto,
                telefone = dto.telefone,
                email = dto.email,
                dataNascimento = dto.dataNascimento,
                sexo = dto.sexo,
                dataCadastro = dto.dataCadastro,
                endereco = dto.endereco,
                dataUltimaAtualizacao = dto.dataUltimaAtualizacao,
            )
        }
    }

}