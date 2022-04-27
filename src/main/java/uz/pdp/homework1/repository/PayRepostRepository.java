package uz.pdp.homework1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.homework1.entity.PayReport;

@RepositoryRestResource(path = "payReport")
public interface PayRepostRepository extends JpaRepository<PayReport, Long> {
}
