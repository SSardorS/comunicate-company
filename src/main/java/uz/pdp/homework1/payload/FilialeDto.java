package uz.pdp.homework1.payload;

import lombok.Data;

import java.util.Set;

@Data
public class FilialeDto {

    private String filiale;

    private Set<Long> userId;
}
