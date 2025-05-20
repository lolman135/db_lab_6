package labs.db_lab_6.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "contexts")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Context {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "filter")
    private String filter;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDate date;

    @ManyToMany(mappedBy = "contexts")
    @JsonBackReference(value = "request-context")
    private Set<Request> request;
}
