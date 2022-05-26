package Spring.batch.modelFront;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {

    private Integer id;
    private LocalDateTime bookingDate;
    private Accountfront account;
    private Bookfront bookpret;
    private LocalDateTime bookingDateEnd;
    private boolean outOfTime;

    @Override
    public String toString() {
        return "Borrowingfront{" +
                "N°=" + id +
                ", date debut=" + bookingDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", nom =" + account.getLastName() +
                ", prenom =" + account.getLastName() +
                ", mail =" + account.getMail() +
                ", date fin=" + bookingDateEnd.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}';
    }
}
