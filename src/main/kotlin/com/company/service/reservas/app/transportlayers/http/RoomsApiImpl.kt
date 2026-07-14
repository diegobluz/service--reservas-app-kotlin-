package com.company.service.reservas.app.transportlayers.http

import com.company.service.reservas.app.entities.dto.RoomDTO
import com.company.service.reservas.app.entities.enums.RoomStatus
import com.company.service.reservas.app.interactors.RoomUseCase
import com.company.service.reservas.app.transportlayers.http.request.RoomRequest
import com.company.service.reservas.app.transportlayers.http.response.RoomResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class RoomsApiImpl (
    private val useCase: RoomUseCase
){

    @PostMapping("/create")
    fun createRoom(@RequestBody request: RoomRequest): ResponseEntity<RoomResponse> {
        val dto = RoomDTO(
            numero = request.numero,
            categoria = request.categoria,
            precoNoite = request.precoNoite,
            capacidadeHospedes = request.capacidadeHospedes,
            descricao = request.descricao
        )
        return ResponseEntity.ok(RoomResponse(useCase.criar(dto)))
    }

    @GetMapping("/{numero}")
    fun getRoom(@PathVariable numero: Int): ResponseEntity<RoomResponse> {
        val room = useCase.obterPorNumero(numero)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(RoomResponse(room))
    }

    @GetMapping("/list")
    fun getAllRooms(): ResponseEntity<List<RoomDTO>> {
        return ResponseEntity.ok(useCase.listarTodos())
    }

    @PatchMapping("/{numero}/status")
    fun updateStatus(
        @PathVariable numero: Int,
        @RequestBody request: RoomStatus
    ): ResponseEntity<RoomResponse> {
        return ResponseEntity.ok(RoomResponse(useCase.atualizarStatus(numero, request)))
    }

}