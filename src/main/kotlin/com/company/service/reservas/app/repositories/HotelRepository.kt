package com.company.service.reservas.app.repositories

import com.company.service.reservas.app.entities.dto.HotelDTO

interface HotelRepository {
    fun obter(): HotelDTO?
    fun salvar(hotel: HotelDTO): HotelDTO
}