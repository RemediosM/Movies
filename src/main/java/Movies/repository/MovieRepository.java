package Movies.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository  extends PagingAndSortingRepository<Movie, Long> {
}
