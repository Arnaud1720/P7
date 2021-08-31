package Spring.batch.modelFront;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Accountfront {

    private int id;
    private String pseudo;
    private String lastName;
    private String fristName;
    private String phoneNumber;
    private String mail;
    private String password;
    private String postalAdress;
    private String city;


    @Override
    public String toString() {
        return "Accountfront{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", postalAdress='" + postalAdress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
