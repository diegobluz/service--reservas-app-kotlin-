package com.company.service.reservas.app.entities.enums

enum class StatusReserve(status: String) {

    CHECKED_IN("Check-in"),
    CHECKED_OUT("Check-out"),
    CANCELED("Canceled"),
    PENDING("Pending"),
    NO_ATTEND("No Attend")

}