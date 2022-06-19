package Movies.controller;

import Movies.dto.BudgetDetailsDto;
import Movies.service.BudgetDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("budgetDetails")
@RequiredArgsConstructor
public class BudgetDetailsController {

    private final BudgetDetailsService budgetDetailsService;

    @PutMapping("update/{id}")
    public void updateBudget(@PathVariable("id") long id, @RequestBody BudgetDetailsDto dto) {
        budgetDetailsService.updateBudgetDetails(id, dto.getCost(), dto.getIncome(), dto.getUpdateDate());
    }

}
