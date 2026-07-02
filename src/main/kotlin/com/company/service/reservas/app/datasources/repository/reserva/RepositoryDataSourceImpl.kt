package com.company.service.reservas.app.datasources.repository

import com.company.service.reservas.app.repositories.ReservaRepository
import com.company.service.reservas.app.transportlayers.request.ReservaRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository

@Repository
class ReservaDataSourceImpl : ReservaRepository {

    override fun create(request: ReservaRequest): ResponseEntity<Any> {
        return ResponseEntity.ok("${request.cpf}")
    }
}