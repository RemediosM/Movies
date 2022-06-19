package Movies.dto;

import Movies.repository.Actor;
import Movies.repository.Contact;
import Movies.repository.Movie;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ActorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private ContactDto contactDto;

    public Actor toEntity() {
        return new Actor(id, firstName, lastName, contactDto.toEntity());
    }

}
