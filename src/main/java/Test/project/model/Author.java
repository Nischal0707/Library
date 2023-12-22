package Test.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@ToString
@Getter
@Setter
@Table
@Entity
public class Author {
@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name="author_id")
    private Long author_id;

    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Book> books;
}
