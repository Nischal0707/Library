package Test.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

import static jakarta.persistence.GenerationType.IDENTITY;

@ToString
@Getter
@Setter
@Table
@Entity
public class Book{
    @Id
    @GeneratedValue(strategy = IDENTITY)
private Long id;

    private String title;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;
}
