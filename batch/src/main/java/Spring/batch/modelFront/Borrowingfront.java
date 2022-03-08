package Spring.batch.modelFront;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Borrowingfront {

    private Integer id;
    private LocalDateTime bookingDate;
    private Accountfront account;
    private Bookfront bookpret;
    private LocalDateTime bookingDateEnd;
    private boolean outOfTime;
    
}
