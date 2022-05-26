package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loanfront {
    private int id;
    private String startDate;
    private String endDate;
    private boolean extension;
    private Accountfront account;
    private Exemplaryfront exemplaryId;
    private String d2 = String.valueOf(LocalDate.now());
}
