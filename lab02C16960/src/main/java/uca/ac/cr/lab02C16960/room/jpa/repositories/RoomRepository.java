package uca.ac.cr.lab02C16960.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ac.cr.lab02C16960.room.jpa.entities.RoomEntity;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findByIdentifier(String identifier);
}
