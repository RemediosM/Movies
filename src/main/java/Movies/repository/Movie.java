package Movies.repository;

import Movies.dto.ActorDto;
import Movies.dto.MovieDto;
import Movies.dto.RewardDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    @Min(1800)
    private int productionYear;
    @OneToOne(cascade = CascadeType.ALL)
    private BudgetDetails budgetDetails;
    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;
    @ManyToMany
    @JoinTable(
            name = "movie_reward",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "reward_id")
    )
    private Set<Reward> rewards;

    public Movie(Long id, String title, int productionYear, BudgetDetails budgetDetails, Set<Actor> actors, Set<Reward> rewards) {
        this.id = id;
        this.title = title;
        this.productionYear = productionYear;
        this.budgetDetails = budgetDetails == null ? new BudgetDetails() : budgetDetails;
        this.actors = actors == null ? new HashSet<>() : actors;
        this.rewards = rewards == null ? new HashSet<>() : rewards;
    }

    public MovieDto toDto() {
        Set<ActorDto> actorDtos = actors.stream()
                .map(Actor::toDto)
                .collect(Collectors.toSet());
        Set<RewardDto> rewardDtos = rewards.stream()
                .map(Reward::toDto)
                .collect(Collectors.toSet());
        return new MovieDto(id, title, productionYear, budgetDetails.toDto(), actorDtos, rewardDtos);
    }
}
