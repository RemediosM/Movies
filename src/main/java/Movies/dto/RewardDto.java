package Movies.dto;

import Movies.repository.Reward;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RewardDto {

    private Long id;
    private String name;

    public Reward toEntity() {
        return new Reward(id, name);
    }

}
