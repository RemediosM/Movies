package Movies.service;

import Movies.repository.Reward;
import Movies.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final RewardRepository rewardRepository;

    public Reward addReward(Reward reward) {
        return rewardRepository.save(reward);
    }

}
