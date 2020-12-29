package crud.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "authorname")
    @NotEmpty
    private String authorName;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @NotNull
    private Boolean deleted = false;

    @UpdateTimestamp
    @Column(updatable = false)
    private Instant deletedAt;

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

}
