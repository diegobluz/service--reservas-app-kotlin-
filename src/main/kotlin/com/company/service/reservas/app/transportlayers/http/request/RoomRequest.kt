package com.company.service.reservas.app.transportlayers.http.request

import com.company.service.reservas.app.entities.enums.CategoryReserve
import java.math.BigDecimal

class RoomRequest {
    var numero: Int? = null
    var categoria: CategoryReserve? = null
    var precoNoite: BigDecimal? = null
    var capacidadeHospedes: Int? = null
    var descricao: String? = null
}