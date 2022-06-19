package Movies;

import Movies.repository.*;
import Movies.service.ActorService;
import Movies.service.MovieService;
import Movies.service.RewardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("populateDB")
@RequiredArgsConstructor
public class PopulateDBWithData {

    private final ActorService actorService;
    private final RewardService rewardService;
    private final MovieService movieService;

    @GetMapping
    void populateDBWithTestData() {
        Contact contact0 = new Contact(0L, "+48111222111", "0@.pl");
        Contact contact1 = new Contact(1L, "+48211222111", "1@.pl");

        Actor actor0 = new Actor(0L, "firstName0", "LastName0", contact0);
        Actor actor1 = new Actor(0L, "firstName1", "LastName1", contact1);
        actor0 = actorService.addActor(actor0);
        actor1 = actorService.addActor(actor1);

        Reward reward0 = new Reward(0L, "reward1");
        Reward reward1 = new Reward(1L, "reward2");
        Reward reward2 = new Reward(2L, "reward3");
        reward0 = rewardService.addReward(reward0);
        reward1 =rewardService.addReward(reward1);
        reward2 = rewardService.addReward(reward2);

        BudgetDetails budgetDetails0 = new BudgetDetails(0L, BigDecimal.valueOf(15e6), null, null);
        BudgetDetails budgetDetails1 = new BudgetDetails(1L, BigDecimal.valueOf(3e6), BigDecimal.valueOf(7e6), null);

        Movie movie0 = new Movie(0L, "title0", 1990, budgetDetails0, Set.of(actor0), Set.of(reward0, reward2));
        Movie movie1 = new Movie(1L, "title1", 1990, budgetDetails1, Set.of(actor0, actor1), Set.of(reward0, reward1, reward2));
        movieService.addMovie(movie0);
        movieService.addMovie(movie1);
        for (int i = 0; i < 20; i++){
            movieService.addMovie(new Movie((long) i, ("title " + i), 1800 + i,budgetDetails0,Set.of(actor0), Set.of(reward0, reward2) ));
        }
    }

}
