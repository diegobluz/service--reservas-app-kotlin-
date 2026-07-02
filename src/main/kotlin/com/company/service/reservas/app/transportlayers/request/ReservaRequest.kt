package com.company.service.reservas.app.transportlayers.request

import java.time.LocalDate

class ReservaRequest {

    lateinit var cpf: String
    lateinit var nomeCompleto: String
    lateinit var telefone: String
    lateinit var email: String
    lateinit var dataNascimento: LocalDate

}