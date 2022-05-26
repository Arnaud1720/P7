package com.arnaud.front.blibliothequeFront.modelFront;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bookfront {

    private  int bookId;
    private String bookTitle;
    private String bookKide;
    private String bookAuthor;
    private String bookEditor;
    private String bookRef;
    private String bookSynopsis;
    private boolean available;
    private List<Borrowingfront> borrowingList;
    private Exemplaryfront exemplaryId;
    private Borrowingfront borrowingfront;
}
