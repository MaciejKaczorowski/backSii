package sii.recruitment.back.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String pesel;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column
    private boolean isEligibleForDiscount = false;

    public Customer(String firstName, String lastName, String address, String pesel, LocalDate dateOfBirth, boolean isEligibleForDiscount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.isEligibleForDiscount = isEligibleForDiscount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isEligibleForDiscount=" + isEligibleForDiscount +
                '}';
    }

}
