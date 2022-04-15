package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exemplaryfront {

    private int id;
    private Blibliothequefront idBlibliothequefront;
    private int exemplaryNumbers;
    private int remainingexemplary;
    private Bookfront book;
    private int maxExemplaryNumber;
    private List<Borrowingfront> borrowingList;
}
