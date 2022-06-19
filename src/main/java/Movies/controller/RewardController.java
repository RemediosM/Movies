package Movies.controller;

import Movies.dto.RewardDto;
import Movies.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reward")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;

    @PostMapping("new")
    public void addReward(@RequestBody RewardDto rewardDto) {
        rewardService.addReward(rewardDto.toEntity());
    }

}
