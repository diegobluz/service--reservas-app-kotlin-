package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.entities.dto.HotelDTO
import com.company.service.reservas.app.repositories.HotelRepository
import org.springframework.stereotype.Service

@Service
class HotelUseCase(
    private val repository: HotelRepository
) {

    fun obter(): HotelDTO {
        return repository.obter()
            ?: throw IllegalStateException("Hotel ainda não foi cadastrado.")
    }

    fun salvar(hotel: HotelDTO): HotelDTO {
        require(!hotel.nome.isNullOrBlank()) { "Nome do hotel é obrigatório." }
        require(!hotel.endereco.isNullOrBlank()) { "Endereço do hotel é obrigatório." }
        return repository.salvar(hotel)
    }
}