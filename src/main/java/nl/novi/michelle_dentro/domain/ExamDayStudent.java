package nl.novi.michelle_dentro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "examination_days_students")
public class ExamDayStudent implements Serializable {

    @Id
    long exam_day_id;

    @Id
    long student_id;

    @Column
    boolean PassedExam = false;

}
