package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {
    private int id;
    private String startDate;
    private String endDate;
    private boolean extension;
    private Accountfront account;
    private Exemplaryfront exemplaryId;


}
