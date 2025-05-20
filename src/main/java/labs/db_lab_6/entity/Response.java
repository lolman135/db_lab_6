package labs.db_lab_6.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "graphic")
    private String graphic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "request_responses",
            joinColumns = @JoinColumn(name = "response_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id")
    )
    @JsonManagedReference(value = "response-request")
    private Set<Request> requests;

    @OneToMany(mappedBy = "response")
    private List<Dataset> datasets;

    @OneToMany(mappedBy = "response")
    private List<Feedback> feedbacks;
}
