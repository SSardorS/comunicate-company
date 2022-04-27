package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.homework1.entity.Pacet;

@RepositoryRestResource(path = "pacets")
public interface PaketRepository extends JpaRepository<Pacet, Long> {
}
