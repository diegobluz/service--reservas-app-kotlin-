package om.company.service__reservas_app.service__reservas_app.transportlayers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class RoomsApiImpl {

    @GetMapping("/list/rooms")
    fun getRooms(): List<String> {
        return mutableListOf("Room 1", "Room 2", "Room 3");
    }
}