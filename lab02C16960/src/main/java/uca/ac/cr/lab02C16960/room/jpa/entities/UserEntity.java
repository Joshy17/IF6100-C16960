package uca.ac.cr.lab02C16960.room.jpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "c16960users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String alias;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MessageEntity> messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
}
