package uca.ac.cr.lab02C16960.room.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uca.ac.cr.lab02C16960.room.handlers.RoomHandler;
import uca.ac.cr.lab02C16960.room.jpa.entities.RoomEntity;
import uca.ac.cr.lab02C16960.room.jpa.entities.UserEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/C16960/room")
public class JoinRoomController {

    private final RoomHandler roomHandler;

    public JoinRoomController(RoomHandler roomHandler) {
        this.roomHandler = roomHandler;
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinRoom(@RequestBody Map<String, String> request) {
        String roomId = request.get("id");
        String alias = request.get("alias");

        // Validación y manejo de errores
        String result = roomHandler.joinRoom(roomId, alias);
        if (result != null && result.startsWith("El")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        return ResponseEntity.ok("Te has unido a la sala correctamente.");
    }
}
