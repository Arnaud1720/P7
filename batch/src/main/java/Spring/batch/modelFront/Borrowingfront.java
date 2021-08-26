package Spring.batch.modelFront;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean extension;
    private Accountfront account;
    private Exemplaryfront exemplaryId;


}
