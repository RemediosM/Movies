package Movies.repository;

import Movies.dto.ContactDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// todo na tę chwilę kontakt jest tworzony i obsługiwany tylko i wyłącznie za pośrednictwem Actot -- trzeba by dodać ContactRepository i Service
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    private String phoneNumber;
    private String email;

    public ContactDto toDto() {
        return new ContactDto(id, phoneNumber, email);
    }
}
