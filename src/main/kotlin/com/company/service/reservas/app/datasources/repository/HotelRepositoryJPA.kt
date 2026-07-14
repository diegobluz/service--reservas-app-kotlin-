package com.company.service.reservas.app.datasources.repository

import com.company.service.reservas.app.entities.HotelEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepositoryJPA : JpaRepository<HotelEntity, Long> {
}