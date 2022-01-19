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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime debutDatePret;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime finDatePret;
    private String emailPret;


    public LocalDateTime getDebutDatePret() {
        return debutDatePret;
    }



}
