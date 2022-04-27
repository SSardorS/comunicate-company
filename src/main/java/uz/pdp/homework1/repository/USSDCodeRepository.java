package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.USSDcode;

import java.util.Optional;

public interface USSDCodeRepository extends JpaRepository<USSDcode, Long> {
    boolean existsByCode(int code);

    Optional<USSDcode> findByCode(int code);
}
