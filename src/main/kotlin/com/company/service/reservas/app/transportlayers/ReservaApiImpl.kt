package com.company.service.reservas.app.transportlayers

import com.company.service.reservas.app.interactors.ReservaUseCase
import com.company.service.reservas.app.transportlayers.mappers.ClienteMapper
import com.company.service.reservas.app.transportlayers.request.ClienteRequest
import com.company.service.reservas.app.transportlayers.request.ReservaRequest
import com.company.service.reservas.app.transportlayers.response.ClienteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/reserva")
class ReservaApiImpl(
    private val useCase: ReservaUseCase,
    private val mapper: ClienteMapper
) {

    @PostMapping("/create")
    fun createReserva(@RequestBody request: ReservaRequest): ResponseEntity<Any> {
        val response = useCase.execute(request)
        return ResponseEntity.ok(response)
    }

}