package com.company.service.reservas.app.entities.dto

import java.time.LocalDate
import java.time.LocalDateTime

class ClienteDTO(
    var id: Long? = null,
    var cpf: String? = null,
    var nomeCompleto: String? = null,
    var telefone: String? = null,
    var email: String? = null,
    var dataNascimento: LocalDate? = null,
    var sexo: String? = null,
    var dataCadastro: LocalDateTime? = null,
    var endereco: EnderecoDTO? = null,
    var dataUltimaAtualizacao: LocalDateTime? = null,
) { 
    fun copy(): ClienteDTO {
        return ClienteDTO()
    }

}