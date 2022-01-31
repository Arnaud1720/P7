package com.arnaud.front.blibliothequeFront.modelFront;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pretfront {

    private Long id;
    private LocalDateTime dateTimeJ;
    private Accountfront accountP;
    private Bookfront bookpret;





}
