package Movies.repository;

import Movies.dto.RewardDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Reward {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public RewardDto toDto() {
        return new RewardDto(id, name);
    }
}
