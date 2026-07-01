package om.company.service__reservas_app.service__reservas_app.transportlayers

import om.company.service__reservas_app.service__reservas_app.interactors.ClienteUseCase
import om.company.service__reservas_app.service__reservas_app.transportlayers.mappers.ClienteMapper
import om.company.service__reservas_app.service__reservas_app.transportlayers.request.ClienteRequest
import om.company.service__reservas_app.service__reservas_app.transportlayers.response.ClienteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/clientes")
class ClienteApiImpl(
    private val clienteUseCase: ClienteUseCase,
    private val mapper: ClienteMapper
) {

    @PostMapping("/create")
    fun createClient(@RequestBody request: ClienteRequest): ResponseEntity<ClienteResponse> {
        val client = mapper.requestClientTO(request)
        val response = mapper.clienteDTOTo(clienteUseCase.execute(client))
        return ResponseEntity.ok(response)
    }

}