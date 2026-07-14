package com.company.service.reservas.app.entities.dto

import com.company.service.reservas.app.entities.enums.CategoryReserve
import com.company.service.reservas.app.entities.enums.RoomStatus
import java.math.BigDecimal

data class RoomDTO(
    var id: Long? = null,
    var numero: Int? = null,
    var categoria: CategoryReserve? = null,
    var status: RoomStatus? = RoomStatus.AVAILABLE,
    var precoNoite: BigDecimal? = null,
    var capacidadeHospedes: Int? = null,
    var descricao: String? = null
)
