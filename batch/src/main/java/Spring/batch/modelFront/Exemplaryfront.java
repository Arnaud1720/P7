package Spring.batch.modelFront;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exemplaryfront {

    private int id;
    private Blibliothequefront idBlibliothequefront;
    private int exemplaryNumbers;
    private int remainingexemplary;

}
