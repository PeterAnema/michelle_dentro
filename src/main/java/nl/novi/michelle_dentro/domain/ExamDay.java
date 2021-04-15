package nl.novi.michelle_dentro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @ManyToMany(mappedBy = "examDayAsCoordinator", cascade = CascadeType.ALL)
    private List<Member> coordinator;

    @ManyToMany(mappedBy = "examDayAsExaminator", cascade = CascadeType.ALL)
    private List<Member> examinators;

    @ManyToMany(mappedBy = "examDayAsStudent", cascade = CascadeType.ALL)
    private List<Member> students;

}
