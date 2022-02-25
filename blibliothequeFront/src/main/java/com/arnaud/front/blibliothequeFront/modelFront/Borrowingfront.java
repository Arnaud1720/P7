package com.arnaud.front.blibliothequeFront.modelFront;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {

    private Integer id;
    private LocalDateTime bookingDate;
    private Accountfront account;
    private Bookfront bookpret;
    private LocalDateTime bookingDateEnd;





}
