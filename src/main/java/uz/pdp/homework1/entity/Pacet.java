package uz.pdp.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.homework1.entity.enums.PacetEnum;
import uz.pdp.homework1.entity.templete.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pacet  extends AbstractEntity {

    private int amount;

    private Double price;

    @Enumerated(value = EnumType.STRING)
    private PacetEnum pacetEnum;
}
