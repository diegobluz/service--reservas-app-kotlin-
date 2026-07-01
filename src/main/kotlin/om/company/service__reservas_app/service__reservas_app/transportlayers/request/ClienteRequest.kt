package om.company.service__reservas_app.service__reservas_app.transportlayers.request

import om.company.service__reservas_app.service__reservas_app.entities.dto.EnderecoDTO
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