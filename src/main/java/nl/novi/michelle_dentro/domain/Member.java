package nl.novi.michelle_dentro.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private MemberType type;

    @Column
    private int level = 0;  // only for students

    @OneToOne(mappedBy = "coordinator", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "coordinator", "examinators", "students" })
    private ExamDay examDayAsCoordinator;

    @ManyToMany(mappedBy = "examinators", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "coordinator", "examinators", "students" })
    private List<ExamDay> examDaysAsExaminator = new ArrayList<>();

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "coordinator", "examinators", "students" })
    private List<ExamDay> examDaysAsStudent = new ArrayList<>();

}
