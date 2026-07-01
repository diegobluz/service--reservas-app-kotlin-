package om.company.service__reservas_app.service__reservas_app.interactors

import om.company.service__reservas_app.service__reservas_app.entities.dto.ClienteDTO
import om.company.service__reservas_app.service__reservas_app.interactors.mappers.ClienteMapper
import om.company.service__reservas_app.service__reservas_app.repositories.ClienteRepository
import om.company.service__reservas_app.service__reservas_app.utils.Validate
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class ClienteUseCase(
    private val repository: ClienteRepository
) {

    fun execute(cliente: ClienteDTO): ClienteDTO {

        val isValidateAge = validateAge(cliente.dataNascimento!!)
        if (!isValidateAge){
            throw IllegalArgumentException("Cliente deve ter 18 anos ou mais.")
        }
        val cpfFormatado = validateCPF(cliente.cpf)

        return repository.save(ClienteMapper.mapper(cliente, cpfFormatado))
    }

   private fun validateAge(dataNasc: LocalDate): Boolean {
        val anos = ChronoUnit.YEARS.between(dataNasc, LocalDate.now())
        return anos >= 18
    }

    private fun validateCPF(cpf: String?): String {
        return Validate.validarCpf(cpf) ?: throw IllegalArgumentException("CPF inválido.")
    }



}

