package uca.ac.cr.lab02C16960.room.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uca.ac.cr.lab02C16960.room.handlers.RoomHandler;

import java.util.Map;

@RestController
@RequestMapping("/api/C16960/room")
public class CreateRoomController {
    private final RoomHandler roomHandler;

    public CreateRoomController(RoomHandler roomHandler) {
        this.roomHandler = roomHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String createdBy = request.get("createdBy");

        // Validación y manejo de errores
        String result = roomHandler.createRoom(name, createdBy);
        if (result != null && result.startsWith("El")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo crear la sala.");
        }

        return ResponseEntity.ok(result); // Devuelve el identificador de la sala
    }
}
