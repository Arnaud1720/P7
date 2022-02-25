package Spring.batch.modelFront;

import lombok.*;

import java.time.LocalDateTime;

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

    @Override
    public String toString() {
        return "Borrowingfront{" +
                "id=" + id +
                ", date de réservation=" + bookingDate +
                ", date limite =" + bookingDateEnd +
                '}';
    }
}
