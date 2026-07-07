package com.company.service.reservas.app.transportlayers.http.response

class ReserveResponse {
    data class ReserveResponse(
    val mensagem: String? = null,
    val daysToCheckin: Long? = null,
    val daysLodgedIn: Long? = null
    )
}