package uz.pdp.homework1.payload;

import lombok.Data;
import uz.pdp.homework1.entity.User;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class TraficDto {
    private String trafficName;

    private Double trafficSum;

    //tarifga  otish summasi
    private Double trafficNds;

    private String description;


}
