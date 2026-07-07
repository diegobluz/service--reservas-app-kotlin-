package com.company.service.reservas.app.datasources.repository

import com.company.service.reservas.app.entities.dto.ReserveDTO
import com.company.service.reservas.app.repositories.ReservaRepository
import com.company.service.reservas.app.transportlayers.http.request.ReservaRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class ReservaDataSourceImpl : ReservaRepository {

    override fun create(request: ReservaRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(request.cpf)
    }

    override fun getReserva(request: ReservaRequest): ReserveDTO {
        TODO("Not yet implemented")
    }

    override fun getAllReservas(): List<ReserveDTO> {
        TODO("Not yet implemented")
    }

    override fun getReservePeriod(
        startDate: LocalDate,
        endDate: LocalDate
    ): List<ReserveDTO> {
        TODO("Not yet implemented")
    }
}