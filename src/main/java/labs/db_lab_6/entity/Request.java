package labs.db_lab_6.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "requests")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "request_contexts",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "context_id")
    )
    @JsonManagedReference(value = "request-context")
    private Set<Context> contexts;

    @ManyToMany(mappedBy = "requests")
    @JsonBackReference(value = "response-request")
    private Set<Response> responses;
}
