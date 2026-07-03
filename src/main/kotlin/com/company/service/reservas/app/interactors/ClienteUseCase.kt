package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.entities.dto.ClienteDTO
import com.company.service.reservas.app.interactors.mappers.ClienteMapper
import com.company.service.reservas.app.repositories.ClienteRepository
import com.company.service.reservas.app.utils.Validate
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Objects
import java.util.Optional

@Service
class ClienteUseCase(
    private val repository: ClienteRepository
    //private val cepGateway: CepGateway
) {

    fun execute(cliente: ClienteDTO): ClienteDTO {

        val isValidateAge = validateAge(cliente.dataNascimento!!)
        if (!isValidateAge){
            throw IllegalArgumentException("Cliente deve ter 18 anos ou mais.")
        }
        //valida o formato do cpf e formata
        val cpfFormatado = validateCPF(cliente.cpf)

        //valida se o CPF já existe no banco
        repository.findByCpf(cpfFormatado)
            ?.let { throw IllegalArgumentException("CPF: $cpfFormatado já cadastrado.") }
        /*
        Task 1 - Criar um Gateway onde deve passar um cep e consultar o endereço
                    Regra: Após consultar o endereço deve validar se existe aquele endereço,
                           caso não exista deve lançar uma exceção.
                           Se existir deve cadastrar o encedereço no banco de dados e retornar o endereço cadastrado.
                           Fica a criteiro se irá salvar na tabela endereço ou direto na tabela de Cliente
         */
        //  val endereco = cepGateway.obterEndereco(cep)

        return repository.saveCliente(cliente, cpfFormatado)
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

