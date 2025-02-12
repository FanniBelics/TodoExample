package inf.unideb.hu.todoexample.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DiscriminatorFormula;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tasks")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("CASE WHEN due_date IS NULL THEN 'Task' ELSE 'TaskWithExpiryDate' END")
@Data
public class Task {
    @Id
    private Long id;

    @Column(name = "user_token", nullable = false)
    private String userToken;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "modify_time", nullable = false)
    private LocalDateTime modifyTime;
}
