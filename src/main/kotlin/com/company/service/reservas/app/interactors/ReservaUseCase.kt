package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.entities.enums.StatusReserve
import com.company.service.reservas.app.repositories.ReservaRepository
import com.company.service.reservas.app.transportlayers.http.request.ReservaRequest
import com.company.service.reservas.app.transportlayers.http.response.ReserveResponse
import com.company.service.reservas.app.transportlayers.schedule.ReserveSchedule
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Service
class ReservaUseCase(
    private val repository: ReservaRepository,
    private val status: StatusReserve
) {


    fun execute(request: ReservaRequest): ResponseEntity<Any> {


        if (request.dataSaida.isBefore(request.dataEntrada)) {
            throw IllegalArgumentException("A data de saída não pode ser anterior à data de entrada.")
        }

        val hoje = LocalDate.now()


        val diasParaCheckin = if (hoje.isBefore(request.dataEntrada)) {
            ChronoUnit.DAYS.between(hoje, request.dataEntrada)
        } else {
            0L
        }


        val diasHospedado = if (!hoje.isBefore(request.dataEntrada) && hoje.isBefore(request.dataSaida)) {

            ChronoUnit.DAYS.between(request.dataEntrada, hoje)
        } else if (!hoje.isBefore(request.dataSaida)) {

            ChronoUnit.DAYS.between(request.dataEntrada, request.dataSaida)
        } else {

            0L
        }


        val response = ReserveResponse.ReserveResponse(
            mensagem = "Reserva processada com sucesso.",
            daysToCheckin = diasParaCheckin,
            daysLodgedIn = diasHospedado
        )


        return ResponseEntity.ok(response)
    }

}

