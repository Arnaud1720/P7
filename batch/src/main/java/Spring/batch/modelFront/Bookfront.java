package Spring.batch.modelFront;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bookfront {

    private int bookId;
    private String bookTitle;
    private String bookKide;
    private String bookAuthor;
    private String bookEditor;
    private String bookRef;
    private String bookSynopsis;
    private Exemplaryfront exemplaryId;
    private boolean available;
    private Accountfront account;

}
