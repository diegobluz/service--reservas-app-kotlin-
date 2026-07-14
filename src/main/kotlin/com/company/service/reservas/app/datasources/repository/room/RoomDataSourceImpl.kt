package com.company.service.reservas.app.datasources.repository.room

import com.company.service.reservas.app.datasources.repository.RoomRepositoryJPA
import com.company.service.reservas.app.entities.RoomEntity
import com.company.service.reservas.app.entities.dto.RoomDTO
import com.company.service.reservas.app.entities.enums.RoomStatus
import com.company.service.reservas.app.repositories.RoomRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime


@Repository
class RoomDataSourceImpl(
    private val roomRepositoryJPA: RoomRepositoryJPA
) : RoomRepository {

    override fun criar(room: RoomDTO): RoomDTO {
        val entity = RoomEntity(
            numero = room.numero,
            categoria = room.categoria,
            status = room.status ?: RoomStatus.AVAILABLE,
            precoNoite = room.precoNoite,
            capacidadeHospedes = room.capacidadeHospedes,
            descricao = room.descricao
        )
        return toDTO(roomRepositoryJPA.save(entity))
    }

    override fun obterPorNumero(numero: Int): RoomDTO? {
        return roomRepositoryJPA.findByNumero(numero)?.let { toDTO(it) }
    }

    override fun listarTodos(): List<RoomDTO> {
        return roomRepositoryJPA.findAll().map { toDTO(it) }
    }

    override fun atualizarStatus(numero: Int, status: RoomStatus): RoomDTO? {
        val entity = roomRepositoryJPA.findByNumero(numero) ?: return null
        entity.status = status
        return toDTO(roomRepositoryJPA.save(entity))
    }

    private fun toDTO(entity: RoomEntity): RoomDTO {
        return RoomDTO(
            id = entity.id,
            numero = entity.numero,
            categoria = entity.categoria,
            status = entity.status,
            precoNoite = entity.precoNoite,
            capacidadeHospedes = entity.capacidadeHospedes,
            descricao = entity.descricao
        )
    }
}