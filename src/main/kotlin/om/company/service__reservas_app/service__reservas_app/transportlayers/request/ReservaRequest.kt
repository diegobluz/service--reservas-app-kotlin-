package om.company.service__reservas_app.service__reservas_app.transportlayers.request

import java.time.LocalDate

class ReservaRequest {

    lateinit var cpf: String
    lateinit var nomeCompleto: String
    lateinit var telefone: String
    lateinit var email: String
    lateinit var dataNascimento: LocalDate

}