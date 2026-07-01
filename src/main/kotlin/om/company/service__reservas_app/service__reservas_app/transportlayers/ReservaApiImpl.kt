package om.company.service__reservas_app.service__reservas_app.transportlayers

import om.company.service__reservas_app.service__reservas_app.interactors.ClienteUseCase
import om.company.service__reservas_app.service__reservas_app.interactors.ReservaUseCase
import om.company.service__reservas_app.service__reservas_app.transportlayers.mappers.ClienteMapper
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ClienteRequest
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ReservaRequest
import om.company.service__reservas_app.service__reservas_app.transportlayers.response.ClienteResponse
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