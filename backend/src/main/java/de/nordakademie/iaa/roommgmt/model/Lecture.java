package de.nordakademie.iaa.roommgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity entity.
 *
 * @author Stephan Anft
 */
@Entity
public class Lecture implements Serializable {

    private static final long serialVersionUID = -8919215764600439763L;

    private Long id;
    private Date begin;
    private Date end;
    private Course course;
    private Room room;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @ManyToOne(optional = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(optional = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
