package com.company.service.reservas.app.repositories

import com.company.service.reservas.app.transportlayers.request.ReservaRequest
import org.springframework.http.ResponseEntity

interface ReservaRepository {

    fun create(request: ReservaRequest): ResponseEntity<Any>


}