package nl.novi.michelle_dentro.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;

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

}
