package Spring.batch.modelFront;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Loanfront {
    private int id;
    private String startDate;
    private String endDate;
    private boolean extension;
    private Accountfront account;
    private Exemplaryfront exemplaryId;

}
