package Spring.batch.modelFront;


import lombok.*;

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


    @Override
    public String toString() {
        return "Borrowingfront{" +
                "startdate"+startDate+
                ", endDate=" + endDate +
                ", account=" + account +
                '}';
    }
}
