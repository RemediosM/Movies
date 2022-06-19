package Movies.service;

import Movies.repository.Actor;
import Movies.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

}
