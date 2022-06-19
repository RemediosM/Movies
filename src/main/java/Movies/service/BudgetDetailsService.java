package Movies.service;

import Movies.repository.BudgetDetails;
import Movies.repository.BudgetDetailsRepository;
import Movies.repository.Movie;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetDetailsService {

    private final BudgetDetailsRepository budgetDetailsRepository;

    public void updateBudgetDetails(Long budgetDetailsId, @Nullable BigDecimal cost, @Nullable BigDecimal income, @Nullable ZonedDateTime updateTime) {
        Optional<BudgetDetails> budgetDetails = budgetDetailsRepository.findById(budgetDetailsId);
        budgetDetails.ifPresent(b -> {
            if (cost != null) {
                b.setCost(cost);
            }
            if (income != null) {
                b.setIncome(income);
            }
            if (updateTime != null) {
                b.setUpdateDate(updateTime);
            } else {
                b.setUpdateDate(ZonedDateTime.now());
            }
            budgetDetailsRepository.save(b);
        });
    }

}
