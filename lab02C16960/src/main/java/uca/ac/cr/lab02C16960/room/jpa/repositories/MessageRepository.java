package uca.ac.cr.lab02C16960.room.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uca.ac.cr.lab02C16960.room.jpa.entities.UserEntity;
import uca.ac.cr.lab02C16960.room.jpa.entities.MessageEntity;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByUser(UserEntity user);
}
