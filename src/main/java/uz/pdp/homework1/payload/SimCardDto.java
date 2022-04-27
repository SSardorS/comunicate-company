package uz.pdp.homework1.payload;

import lombok.Data;

@Data
public class SimCardDto {

    private String number;


    private Long owner;

    private Double sum;

    private Double simSum;

    private Long trafic;

    private boolean active;
}
