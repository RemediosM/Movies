package Movies.dto;

import Movies.repository.Contact;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ContactDto {

    private Long id;
    private String phoneNumber;
    private String email;

    public Contact toEntity() {
        return new Contact(id, phoneNumber, email);
    }

}
