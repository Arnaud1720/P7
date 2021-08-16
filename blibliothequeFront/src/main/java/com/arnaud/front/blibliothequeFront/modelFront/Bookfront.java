package com.arnaud.front.blibliothequeFront.modelFront;

import lombok.*;


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
