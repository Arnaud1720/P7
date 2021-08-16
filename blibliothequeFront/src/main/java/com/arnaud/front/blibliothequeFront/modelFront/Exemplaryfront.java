package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exemplaryfront {

    private int id;
    private Blibliothequefront idBlibliothequefront;
    private int exemplaryNumbers;
    private int remainingexemplary;

}
