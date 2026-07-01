package om.company.service__reservas_app.service__reservas_app.repositories

import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ReservaRequest
import org.springframework.http.ResponseEntity

interface ReservaRepository {

    fun create(request: ReservaRequest): ResponseEntity<Any>


}