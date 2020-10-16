package de.nordakademie.iaa.roommgmt.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Course entity.
 *
 * @author Stephan Anft
 */
@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 4823420203175053129L;

    private Long id;
    private String fieldOfStudy;
    private Integer number;
    private String lecturer;
    private String title;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIELD_OF_STUDY", nullable = false)
    @NaturalId
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @Column(nullable = false)
    @NaturalId
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(length = 50, nullable = false)
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Column(length = 100, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
