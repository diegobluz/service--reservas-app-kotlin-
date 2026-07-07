package com.company.service.reservas.app.entities.dto

import java.time.LocalDate

class ReserveDTO {

    val status: Any
        get() {
            TODO()
        }
    val cliente : ClienteDTO? = null
    val checkInDate : LocalDate? = null
    val checkOutDate : LocalDate? = null
    val roomNumber : Int? = null


}