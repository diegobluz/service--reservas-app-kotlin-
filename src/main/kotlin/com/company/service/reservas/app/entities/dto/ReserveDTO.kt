package com.company.service.reservas.app.entities.dto

import com.company.service.reservas.app.entities.enums.CategoryReserve
import com.company.service.reservas.app.entities.enums.StatusReserve
import java.time.LocalDate

data class ReserveDTO (

    var id: Long? = null,
    var cliente: ClienteDTO? = null,
    var checkInDate: LocalDate? = null,
    var checkOutDate: LocalDate? = null,
    var roomNumber: Int? = null,
    var category: CategoryReserve? = null,
    var status: StatusReserve? = StatusReserve.PENDING
)