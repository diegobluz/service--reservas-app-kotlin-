package com.company.service.reservas.app.datasources.repository.hotel

import com.company.service.reservas.app.datasources.repository.HotelRepositoryJPA
import com.company.service.reservas.app.entities.HotelEntity
import com.company.service.reservas.app.entities.dto.HotelDTO
import com.company.service.reservas.app.repositories.HotelRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Repository
class HotelDataSourceImpl(
    private val hotelRepositoryJPA: HotelRepositoryJPA
) : HotelRepository {
    override fun obter(): HotelDTO? {
        return hotelRepositoryJPA.findAll().firstOrNull()?.let { toDTO(it) }
    }

    override fun salvar(hotel: HotelDTO): HotelDTO {
        val existente = hotelRepositoryJPA.findAll().firstOrNull()

        val entity = HotelEntity(
            id = existente?.id, // se já existir, atualiza o mesmo registro (hotel único)
            nome = hotel.nome,
            endereco = hotel.endereco,
            comodidades = hotel.comodidades,
            dataCadastro = existente?.dataCadastro ?: LocalDateTime.now(),
            dataUltimaAtualizacao = LocalDateTime.now()
        )

        return toDTO(hotelRepositoryJPA.save(entity))
    }

    private fun toDTO(entity: HotelEntity): HotelDTO {
        return HotelDTO(
            id = entity.id,
            nome = entity.nome,
            endereco = entity.endereco,
            comodidades = entity.comodidades,
            dataCadastro = entity.dataCadastro,
            dataUltimaAtualizacao = entity.dataUltimaAtualizacao
        )
    }
}