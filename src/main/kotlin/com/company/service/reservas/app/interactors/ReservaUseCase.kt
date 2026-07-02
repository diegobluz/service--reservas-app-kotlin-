package com.company.service.reservas.app.interactors

import com.company.service.reservas.app.repositories.ReservaRepository
import com.company.service.reservas.app.transportlayers.request.ReservaRequest
import org.springframework.http.ResponseEntity

class ReservaUseCase(
    private val repository: ReservaRepository
) {

    fun execute(request: ReservaRequest): ResponseEntity<Any> {
        return ResponseEntity.ok("Reserva criada com sucesso!")
    }
}

