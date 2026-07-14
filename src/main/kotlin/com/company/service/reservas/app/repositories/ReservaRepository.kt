package com.company.service.reservas.app.repositories

import com.company.service.reservas.app.entities.dto.ReserveDTO
import com.company.service.reservas.app.entities.enums.StatusReserve
import com.company.service.reservas.app.transportlayers.http.request.ReservaRequest
import org.springframework.http.ResponseEntity

import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface ReservaRepository {


    fun create(request: ReservaRequest): ReserveDTO{
        //TODO criar persistencia
        return ReserveDTO(
            checkInDate = request.dataEntrada,
            checkOutDate = request.dataEntrada,
            status = StatusReserve.PENDING
        )
    }

    //TODO criar ReservaDTO
    fun getReserva(request: ReservaRequest): ReserveDTO

    //TODO criar ReservaDTO
    fun getAllReservas(): List<ReserveDTO>


    fun getReservePeriod(
        startDate: LocalDate,
        endDate: LocalDate
    ): List<ReserveDTO>{
        TODO()

    }

}