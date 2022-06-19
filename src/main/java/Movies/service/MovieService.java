package Movies.service;

import Movies.dto.MovieDto;
import Movies.repository.Actor;
import Movies.repository.Movie;
import Movies.repository.MovieRepository;
import Movies.repository.Reward;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    public void addActors(Long movieId, Set<Actor> actors) {
        Movie movie = getMovie(movieId);
        if (movie != null) {
            movie.getActors().addAll(actors);
            movieRepository.save(movie);
        }
    }

    public void addRewards(Long movieId, Set<Reward> rewards) {
        Movie movie = getMovie(movieId);
        if (movie != null) {
            movie.getRewards().addAll(rewards);
            movieRepository.save(movie);
        }
    }

    public List<Movie> findPaginated(int pageNo, int pageSize){

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Movie> pagedResult = movieRepository.findAll(paging);

        return pagedResult.toList();
    }

}
