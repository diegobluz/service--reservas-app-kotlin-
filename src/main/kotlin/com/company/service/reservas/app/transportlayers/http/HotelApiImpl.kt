package com.company.service.reservas.app.transportlayers.http

import com.company.service.reservas.app.entities.dto.HotelDTO
import com.company.service.reservas.app.interactors.HotelUseCase
import com.company.service.reservas.app.transportlayers.http.request.HotelRequest
import com.company.service.reservas.app.transportlayers.http.response.HotelResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reserve-app")
class HotelApiImpl (
    private val hotelUseCase: HotelUseCase
){


    @PostMapping("/room/create")
    fun createHotel(@RequestBody request: HotelRequest): ResponseEntity<HotelResponse> {
        val dto = HotelDTO(
            nome = request.nome,
            endereco = request.endereco,
            comodidades = request.comodidades
        )
        val hotel = hotelUseCase.salvar(dto)
        return ResponseEntity.ok(HotelResponse(hotel))
    }
    //TODO:  retornar apenas um hotel
    @GetMapping("/room/{roomId}")
    fun getHotel(): ResponseEntity<HotelResponse> {
        return ResponseEntity.ok(HotelResponse(hotelUseCase.obter()))
    }


}