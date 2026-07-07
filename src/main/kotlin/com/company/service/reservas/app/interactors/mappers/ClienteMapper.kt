package com.company.service.reservas.app.interactors.mappers

import com.company.service.reservas.app.entities.dto.ClienteDTO
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