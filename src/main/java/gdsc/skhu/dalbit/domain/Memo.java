package gdsc.skhu.dalbit.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dayplan_id", nullable = false)
    private DayPlan dayPlan;

    @Column
    private String message;

    @Column
    private int spentMoney;
}
