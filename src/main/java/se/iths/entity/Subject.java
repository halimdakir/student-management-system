package se.iths.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String subjectName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    public Subject() {
    }
    public Subject(@NotEmpty String subjectName) {
        this.subjectName = subjectName;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
