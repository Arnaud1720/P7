package com.arnaud.front.blibliothequeFront.modelFront;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {

    private long id;
    private LocalDateTime bookingDate;
    private Accountfront account;
    private Bookfront bookpret;
    private LocalDateTime bookingDateEnd;
    private Exemplaryfront exemplaryId;
    private Bookfront book;
    private int cmpt =0;
    private int total;


}
