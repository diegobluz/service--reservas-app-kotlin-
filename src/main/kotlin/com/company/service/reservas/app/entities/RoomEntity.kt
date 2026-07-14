package com.company.service.reservas.app.entities

import com.company.service.reservas.app.entities.enums.CategoryReserve
import com.company.service.reservas.app.entities.enums.RoomStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "quarto")
class RoomEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "numero", unique = true)
    var numero: Int? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    var categoria: CategoryReserve? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: RoomStatus? = null,

    @Column(name = "preco_noite")
    var precoNoite: BigDecimal? = null,

    @Column(name = "capacidade_hospedes")
    var capacidadeHospedes: Int? = null,

    @Column(name = "descricao", length = 255)
    var descricao: String? = null
)