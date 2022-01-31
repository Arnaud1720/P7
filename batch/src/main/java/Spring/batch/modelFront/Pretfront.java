package Spring.batch.modelFront;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Pretfront implements Serializable {

    private Long id;
    private String dateTimeJ;
    private Accountfront accountP;
    private Bookfront bookpret;

    @Override
    public String toString() {
        return "Pretfront{" +
                "dateTimeJ='" + dateTimeJ + '\'' +
                '}';
    }
}
