package Movies.repository;

import Movies.dto.BudgetDetailsDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
public class BudgetDetails {

    @Id
    @GeneratedValue
    private Long id;
    @Setter
    private BigDecimal cost;
    @Setter
    private BigDecimal income;
    @Setter
    private ZonedDateTime updateDate;

    public BudgetDetails(Long id, BigDecimal cost, BigDecimal income, ZonedDateTime updateDate) {
        this.id = id;
        this.cost = cost;
        this.income = income;
        this.updateDate = updateDate == null ? ZonedDateTime.now() : updateDate;
    }

    public BudgetDetailsDto toDto() {
        return new BudgetDetailsDto(id, cost, income, updateDate);
    }
}
