package com.company.service.reservas.app.transportlayers.http.request

import com.company.service.reservas.app.entities.dto.EnderecoDTO
import java.time.LocalDate

class ClienteRequest {

    lateinit var cpf: String
    lateinit var nomeCompleto: String
    var telefone: String? = null
    var email: String? = null
    lateinit var dataNascimento: LocalDate
    lateinit var sexo: String
    lateinit var endereco: EnderecoDTO
}