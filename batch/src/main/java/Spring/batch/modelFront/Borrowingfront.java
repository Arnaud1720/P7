package Spring.batch.modelFront;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrowingfront {

    private Long id;
    private LocalDateTime dateTimeJ;
    private Accountfront accountP;
    private Bookfront bookpret;





}
