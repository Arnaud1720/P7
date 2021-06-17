package com.arnaud.front.blibliothequeFront.modelFront;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blibliothequefront {

    private int id;
    private String name;
    private String city;
    private String streetNumber;
    private int surface;


}
