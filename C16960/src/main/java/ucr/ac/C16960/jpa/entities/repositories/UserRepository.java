package ucr.ac.C16960.jpa.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.ac.C16960.jpa.entities.UserEntity;

import java.util.UUID;
import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {


    Optional<UserEntity> findByEmail(String email);

    Long countByEmail(String email);


    //@Query(nativeQuery = true, value = "SELECT * FROM users WHERE name = :name")//SQL
    //@Query("SELECT u FROM UserEntity u WHERE u.name = :name")// HQL
    List<UserEntity> findByName(String name);

}
