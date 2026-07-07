package com.company.service.reservas.app.transportlayers.http

import com.company.service.reservas.app.transportlayers.http.request.ClienteRequest
import com.company.service.reservas.app.transportlayers.http.response.ClienteResponse
import com.company.service.reservas.app.transportlayers.http.response.HotelResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reserve-app")
class HotelApiImpl {


    @PostMapping("/room/create")
    fun createHotel(@RequestBody request: ClienteRequest): ResponseEntity<HotelResponse> {
        return ResponseEntity.ok(null)
    }
    //TODO:  retornar apenas um hotel
    @GetMapping("/room/{roomId}")
    fun getHotel(): String {
        return "Hotel 1";
    }

    //TODO:  retornar uma lista de hotel
    @GetMapping("/list/all/rooms")
    fun getAllHotel(): List<HotelResponse> {
        return mutableListOf(HotelResponse())
    }



}