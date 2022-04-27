package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.SimCard;
import uz.pdp.homework1.entity.User;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public interface SimCardRepository extends JpaRepository<SimCard, Long> {
    boolean existsByNumber(String number);

    Optional<SimCard> findByOwner(User owner);

    Set<SimCard> findByCreatedAtBetween(Timestamp createdAt, Timestamp createdAt2);
}
