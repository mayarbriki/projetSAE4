package esprit.microservice2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;

    @Column(name = "created_At")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Lob
    @JsonIgnore
    private byte[] image;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

    public Integer getImageHashCode() {
        return this.image!=null ? Arrays.hashCode(this.image):null;
    }

}
