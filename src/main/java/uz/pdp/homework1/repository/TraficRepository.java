package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.Trafics;

public interface TraficRepository extends JpaRepository<Trafics, Long> {
    boolean existsByTrafficName(String trafficName);
}
