package nl.novi.michelle_dentro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "examination_days")
@Getter
@Setter
public class ExamDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private LocalDateTime date;

    @OneToOne
    @JsonIgnoreProperties({ "examDayAsCoordinator", "examDaysAsExaminator", "examDaysAsStudent" })
    private Member coordinator;

    @ManyToMany
    @JsonIgnoreProperties({ "examDayAsCoordinator", "examDaysAsExaminator", "examDaysAsStudent" })
    private List<Member> examinators = new ArrayList<>();

    @ManyToMany
    @JsonIgnoreProperties({ "examDayAsCoordinator", "examDaysAsExaminator", "examDaysAsStudent" })
    private List<Member> students = new ArrayList<>();

}
