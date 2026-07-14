package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.entities.dto.RoomDTO
import com.company.service.reservas.app.entities.enums.RoomStatus
import com.company.service.reservas.app.repositories.RoomRepository
import org.springframework.stereotype.Service

@Service
class RoomUseCase(
    private val repository: RoomRepository
) {

    fun criar(room: RoomDTO): RoomDTO {
        require(room.numero != null) { "Número do quarto é obrigatório." }
        repository.obterPorNumero(room.numero!!)
            ?.let { throw IllegalArgumentException("Já existe um quarto com o número ${room.numero}.") }
        return repository.criar(room)
    }

    fun obterPorNumero(numero: Int): RoomDTO? = repository.obterPorNumero(numero)

    fun listarTodos(): List<RoomDTO> = repository.listarTodos()

    fun atualizarStatus(numero: Int, status: RoomStatus): RoomDTO {
        return repository.atualizarStatus(numero, status)
            ?: throw NoSuchElementException("Quarto número $numero não encontrado.")
    }
}