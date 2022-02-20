package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;

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


}
