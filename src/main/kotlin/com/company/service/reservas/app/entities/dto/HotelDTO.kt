package com.company.service.reservas.app.entities.dto

import java.time.LocalDateTime

data class HotelDTO(
    var id: Long? = null,
    var nome: String? = null,
    var endereco: String? = null,
    var comodidades: String? = null,
    var dataCadastro: LocalDateTime? = null,
    var dataUltimaAtualizacao: LocalDateTime? = null
)
