package com.company.service.reservas.app.transportlayers.http.request

import java.time.LocalDate

class ReservaRequest {

    lateinit var cpf: String
    lateinit var nomeCompleto: String
    lateinit var telefone: String
    lateinit var email: String
    lateinit var dataNascimento: LocalDate
    lateinit var dataEntrada: LocalDate
    lateinit var dataSaida: LocalDate

}