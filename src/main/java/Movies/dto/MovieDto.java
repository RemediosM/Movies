package Movies.dto;

import Movies.repository.Actor;
import Movies.repository.BudgetDetails;
import Movies.repository.Movie;
import Movies.repository.Reward;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@XmlRootElement
public class MovieDto {

    private Long id;
    private String title;
    private int productionYear;
    private BudgetDetailsDto budgetDetails;
    private Set<ActorDto> actors;
    private Set<RewardDto> rewards;

    public Movie toEntity() {
        Set<Actor> actorsEntity = actors == null ? null : actors.stream().map(ActorDto::toEntity).collect(Collectors.toSet());
        Set<Reward> rewardsEntity = rewards == null ? null : rewards.stream().map(RewardDto::toEntity).collect(Collectors.toSet());
        BudgetDetails budgetDetailsEntity = budgetDetails == null ? null : budgetDetails.toEntity();
        return new Movie(id, title, productionYear, budgetDetailsEntity, actorsEntity, rewardsEntity);
    }

}
