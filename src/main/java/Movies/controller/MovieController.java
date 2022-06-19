package Movies.controller;

import Movies.dto.MovieDto;
import Movies.repository.Movie;
import Movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> getMovieJSON(@PathVariable("id") long id) {
        MovieDto movieDto = movieService.getMovie(id).toDto();
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(movieDto);
    }

    @GetMapping(value = "xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<MovieDto> getMovieXML(@PathVariable("id") long id) {
        MovieDto movieDto = movieService.getMovie(id).toDto();
        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_XML)
                .body(movieDto);
    }

    @PostMapping(value = "new", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void addMovie(@RequestBody MovieDto movieDto) {
        movieService.addMovie(movieDto.toEntity());
    }

    @GetMapping(value = "/json/{pageNo}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDto>> getPaginatedMovies(@PathVariable int pageNo,
                                                             @PathVariable int pageSize) {
        List<MovieDto> moviesDto = movieService.findPaginated(pageNo, pageSize).stream()
                .map(Movie::toDto)
                .toList();

        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(moviesDto);
    }

    @GetMapping(value = "/xml/{pageNo}/{pageSize}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<MovieDto>> getPaginatedMoviesXml(@PathVariable int pageNo,
                                                                @PathVariable int pageSize) {
        List<MovieDto> moviesDto = movieService.findPaginated(pageNo, pageSize).stream()
                .map(Movie::toDto)
                .toList();

        return ResponseEntity.status(200)
                .contentType(MediaType.APPLICATION_XML)
                .body(moviesDto);
    }
}
