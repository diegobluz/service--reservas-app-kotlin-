package com.company.service.reservas.app.repositories

import com.company.service.reservas.app.entities.dto.ReserveDTO
import com.company.service.reservas.app.entities.enums.StatusReserve
import com.company.service.reservas.app.transportlayers.http.request.ReservaRequest
import org.springframework.http.ResponseEntity

import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ReservaRepository {

    //TODO criar ReservaDTO
    fun create(request: ReservaRequest): ResponseEntity<Any>

    //TODO criar ReservaDTO
    fun getReserva(request: ReservaRequest): ReserveDTO

    //TODO criar ReservaDTO
    fun getAllReservas(): List<ReserveDTO>

    //TODO criar retorno como List<ReservaDTO>
    fun getReservePeriod(startDate: LocalDate, endDate: LocalDate): List<ReserveDTO>

}