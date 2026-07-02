package com.company.service.reservas.app.entities.dto

import com.company.service.reservas.app.entities.enums.Estado
import java.time.LocalDateTime

class EnderecoResponse(
    var endereco: EnderecoDTO? = null
)

class EnderecoDTO {
    var cep: String? = null
    var logradouro: String? = null
    var complemento: String? = null
    var numero: String? = null
    var bairro: String? = null
    var localidade: String? = null
    var uf: Estado? = null
    var cpfCliente: String? = null
    var dataCadastro: LocalDateTime? = null
    var dataUltimaAtualizacao: LocalDateTime? = null
}