package Movies.repository;

import Movies.dto.ActorDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
public class Actor {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

    public Actor(Long id, String firstName, String lastName, Contact contact) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public ActorDto toDto() {
        return new ActorDto(id, firstName, lastName, contact.toDto());
    }
}
