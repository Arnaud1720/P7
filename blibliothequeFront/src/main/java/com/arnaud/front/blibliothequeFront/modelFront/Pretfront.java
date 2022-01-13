package com.arnaud.front.blibliothequeFront.modelFront;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pretfront {

    private Long id;
    private LocalDateTime debutDatePret;
    private LocalDateTime finDatePret;
    private String emailPret;


}
