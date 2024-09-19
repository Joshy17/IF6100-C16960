package uca.ac.cr.lab02C16960.room.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uca.ac.cr.lab02C16960.room.handlers.MessageHandler;
import uca.ac.cr.lab02C16960.room.jpa.entities.MessageEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/C16960/room")
public class MessageController {

    private final MessageHandler messageHandler;

    public MessageController(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, String> request) {
        String roomId = request.get("id");
        String alias = request.get("alias");
        String message = request.get("message");

        // Validación y manejo de errores
        String result = messageHandler.sendMessage(roomId, alias, message);
        if (result != null && result.startsWith("El")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        return ResponseEntity.ok("Mensaje enviado correctamente.");
    }

    @GetMapping("/message")
    public ResponseEntity<Object> getMessages(@RequestParam String id) {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El identificador de la sala no puede ser vacío.");
        }

        List<MessageEntity> messages = messageHandler.getMessages(id);
        if (messages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay mensajes o la sala no es válida.");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("messages", messages.stream().map(msg -> {
            Map<String, Object> messageMap = new HashMap<>();
            messageMap.put("alias", msg.getUser().getAlias());
            messageMap.put("message", msg.getMessage());
            messageMap.put("createdOn", msg.getCreatedOn());
            return messageMap;
        }).collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }
}
