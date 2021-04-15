package nl.novi.michelle_dentro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
    private Date date;

    @OneToOne
    private Member coordinator;

    @OneToMany(mappedBy = "examDay", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Member> students;

    @OneToMany(mappedBy = "examDay", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Member> examinators;

}
