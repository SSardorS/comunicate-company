package uz.pdp.homework1.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Period {

    private Timestamp startTime;

    private Timestamp endTime;
}
