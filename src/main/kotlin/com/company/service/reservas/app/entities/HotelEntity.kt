package com.company.service.reservas.app.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "hotel")
class HotelEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "nome", length = 100)
    var nome: String? = null,

    @Column(name = "endereco", length = 150)
    var endereco: String? = null,

    @Column(name = "comodidades", length = 255)
    var comodidades: String? = null,

    @Column(name = "data_cadastro")
    var dataCadastro: LocalDateTime? = null,

    @Column(name = "data_ultima_atualizacao")
    var dataUltimaAtualizacao: LocalDateTime? = null
)