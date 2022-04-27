package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.Filiale;

public interface FilialeRepository extends JpaRepository<Filiale,  Long> {
    boolean existsByFiliale(String filiale);
}
