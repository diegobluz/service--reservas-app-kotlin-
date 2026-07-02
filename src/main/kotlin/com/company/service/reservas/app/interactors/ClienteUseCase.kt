package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.entities.dto.ClienteDTO
import com.company.service.reservas.app.interactors.mappers.ClienteMapper
import com.company.service.reservas.app.repositories.ClienteRepository
import com.company.service.reservas.app.utils.Validate
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Service
class ClienteUseCase(
    private val repository: ClienteRepository
) {

    fun execute(cliente: ClienteDTO): ClienteDTO {

        val isValidateAge = validateAge(cliente.dataNascimento!!)
        if (!isValidateAge){
            throw IllegalArgumentException("Cliente deve ter 18 anos ou mais.")
        }
        //valida o formato do cpf e formata
        val cpfFormatado = validateCPF(cliente.cpf)

        //valida se o CPF já existe no banco
        if (repository.findByCpf(cpfFormatado) != null) {
            throw IllegalArgumentException("CPF já cadastrado.")
        }
        return repository.save(ClienteMapper.mapper(cliente, cpfFormatado))
    }

   private fun validateAge(dataNasc: LocalDate): Boolean {
        val anos = ChronoUnit.YEARS.between(dataNasc, LocalDate.now())
        return anos >= 18
    }

    private fun validateCPF(cpf: String?): String {
        return Validate.validarCpf(cpf) ?: throw IllegalArgumentException("CPF inválido.")
    }

    fun findByCpf(cpf: String): ClienteDTO? {

        val cpfFormatado = validateCPF(cpf)
        return repository.findByCpf(cpfFormatado)
    }



}

