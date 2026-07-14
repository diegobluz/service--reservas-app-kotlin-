package com.company.service.reservas.app.repositories

import com.company.service.reservas.app.entities.dto.RoomDTO
import com.company.service.reservas.app.entities.enums.RoomStatus

interface RoomRepository {
    fun criar(room: RoomDTO): RoomDTO
    fun obterPorNumero(numero: Int): RoomDTO?
    fun listarTodos(): List<RoomDTO>
    fun atualizarStatus(numero: Int, status: RoomStatus): RoomDTO?
}