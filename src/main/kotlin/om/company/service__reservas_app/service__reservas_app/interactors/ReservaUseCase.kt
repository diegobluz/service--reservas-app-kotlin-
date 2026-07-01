package om.company.service__reservas_app.service__reservas_app.interactors

import om.company.service__reservas_app.service__reservas_app.repositories.ReservaRepository
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ReservaRequest
import org.springframework.http.ResponseEntity

class ReservaUseCase(
    private val repository: ReservaRepository
) {

    fun execute(request: ReservaRequest): ResponseEntity<Any> {
        return ResponseEntity.ok("Reserva criada com sucesso!")
    }
}

