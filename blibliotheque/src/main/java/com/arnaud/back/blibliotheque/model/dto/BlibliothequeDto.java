package com.arnaud.back.blibliotheque.model.dto;

import com.arnaud.back.blibliotheque.model.Blibliotheque;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BlibliothequeDto {
    private Integer id;
    private String name;
    private String city;
    private String streetNumber;
    private int surface;

    //mapping Blibliotheque -> BlibliothequeDto
        public BlibliothequeDto fromEntity(Blibliotheque blibliotheque){
            if(blibliotheque==null){
                //todo Throw an Exception
                return null;
            }
            return BlibliothequeDto.builder()
                    .id(blibliotheque.getId())
                    .name(blibliotheque.getName())
                    .city(blibliotheque.getCity())
                    .streetNumber(blibliotheque.getStreetNumber())
                    .surface(blibliotheque.getSurface()).build();
        }
    //mapping BlibliothequeDto -> Blibliotheque
    public  Blibliotheque toEntity(BlibliothequeDto blibliothequeDto){
            Blibliotheque blibliotheque = new Blibliotheque();
            blibliotheque.setId(blibliothequeDto.getId());
            blibliotheque.setName(blibliothequeDto.getName());
            blibliotheque.setCity(blibliothequeDto.getCity());
            blibliotheque.setStreetNumber(blibliothequeDto.getStreetNumber());
            blibliotheque.setSurface(blibliothequeDto.getSurface());
            return blibliotheque;
    }
}
