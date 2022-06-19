package Movies.dto;

import Movies.repository.BudgetDetails;
import lombok.*;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BudgetDetailsDto {

    private Long id;
    private BigDecimal cost;
    private BigDecimal income;
    private ZonedDateTime updateDate;

    public BudgetDetails toEntity() {
        return new BudgetDetails(id, cost, income, updateDate);
    }

}
