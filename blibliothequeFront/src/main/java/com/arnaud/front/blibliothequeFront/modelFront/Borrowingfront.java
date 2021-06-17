package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {

    private int id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private boolean extension;
    private Accountfront accountfront;
    private Exemplaryfront exemplaryfrontId;


}
