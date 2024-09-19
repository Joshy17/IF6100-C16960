package uca.ac.cr.lab02C16960.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ac.cr.lab02C16960.room.jpa.entities.UserEntity;
import uca.ac.cr.lab02C16960.room.jpa.entities.RoomEntity;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByRoom(RoomEntity room);
}

