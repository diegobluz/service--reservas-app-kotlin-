package com.company.service.reservas.app.transportlayers.http.request

class HotelRequest {
    lateinit var nome: String
    lateinit var endereco: String
    var comodidades: String? = null
}