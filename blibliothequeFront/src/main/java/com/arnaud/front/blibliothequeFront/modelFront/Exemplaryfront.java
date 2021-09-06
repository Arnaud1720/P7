package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exemplaryfront {

    private int id;
    private Blibliothequefront idBlibliothequefront;
    private int exemplaryNumbers;
    private int remainingexemplary;

}
