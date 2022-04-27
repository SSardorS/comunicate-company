package uz.pdp.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.homework1.entity.templete.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SimCard extends AbstractEntity {

    @Column(unique = true, length = 9)
    private String number;

    @ManyToOne
    private User owner;

    private Double sum;

    private Double saleSum;

    @ManyToOne
    private Trafics trafic;

    private boolean active;
}
