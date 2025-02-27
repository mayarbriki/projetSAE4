package esprit.microservice1.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JsonIgnoreProperties(value = {"exam"}, allowSetters = true)
    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subjectFather;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subjectChildren;

    @Transient
    private boolean replied;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

    public void setQuestions(List<Question> questions) {
        this.questions.clear();
        questions.forEach(this::addQuestion);
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setExam(this);
    }

    public void removeQuestion(Question question) {
        this.questions.remove(question);
        question.setExam(null);
    }
}
