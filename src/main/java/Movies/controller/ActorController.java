package Movies.controller;

import Movies.dto.ActorDto;
import Movies.repository.Actor;
import Movies.service.ActorService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("{id}")
    public ResponseEntity<ActorDto> getActor(@PathVariable("id") long id) {
        Actor actor = actorService.getActorById(id);
        return ResponseEntity.status(200)
                .body(actor.toDto());
    }

    @PostMapping("new")
    public void addActor(@RequestBody ActorDto actorDto) {
        actorService.addActor(actorDto.toEntity());
    }

}
