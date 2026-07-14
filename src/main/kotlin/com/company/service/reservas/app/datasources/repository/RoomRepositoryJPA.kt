package com.company.service.reservas.app.datasources.repository

import com.company.service.reservas.app.entities.RoomEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepositoryJPA : JpaRepository<RoomEntity, Long> {
    fun findByNumero(numero: Int): RoomEntity?
    fun findAllByStatus(status: String): List<RoomEntity>?
}