package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Account;
import com.arnaud.back.blibliotheque.model.Book;
import com.arnaud.back.blibliotheque.model.Borrowing;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class BorrowingDto {
    private Integer id;
    private LocalDateTime bookingDate;
    private Account account;
    private Book bookpret;
    private LocalDateTime bookingDateEnd;
    private boolean outOfTime;

    // mapping Borrowing -> BorrowingDto fromEntity
    public BorrowingDto fromEntity(Borrowing borrowing){
        if(borrowing==null){
            return null;
        }
        return BorrowingDto.builder()
                .id(borrowing.getId())
                .bookingDate(borrowing.getBookingDate())
                .account(borrowing.getAccount())
                .bookpret(borrowing.getBookpret())
                .bookingDateEnd(borrowing.getBookingDateEnd())
                .outOfTime(borrowing.isOutOfTime()).build();
    }
    //Mapping BorrowingDto -> Borrowing toEntity
        public Borrowing toEntity(BorrowingDto borrowingDto){
        Borrowing borrowing = new Borrowing();
        borrowing.setId(borrowingDto.getId());
        borrowing.setBookingDate(borrowingDto.getBookingDate());
        borrowing.setAccount(borrowingDto.getAccount());
        borrowing.setBookpret(borrowingDto.getBookpret());
        borrowing.setBookingDateEnd(borrowingDto.getBookingDateEnd());
        borrowing.setOutOfTime(borrowingDto.isOutOfTime());
        return borrowing;        }

}
