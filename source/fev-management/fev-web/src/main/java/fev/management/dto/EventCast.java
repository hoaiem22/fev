package fev.management.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import fev.management.entity.FevEventAlbum;
import fev.management.entity.FevEventMember;
import fev.management.entity.FevMember;
import fev.management.entity.FevTransaction;

public class EventCast {
    private Integer id;
    private String name;
    private Date start;
    private Date end;
    private Date time;
    private String place;
    private String leader;
    private String note;
 
    
    public EventCast(Integer id, String name, Date start, Date end, Date time, String place, String leader,
            String note) {
        super();
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.time = time;
        this.place = place;
        this.leader = leader;
        this.note = note;
    }
    /**
    * Get value of id.
    * @return the id
    */
    public Integer getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * Get value of name.
    * @return the name
    */
    public String getName() {
        return name;
    }
    /**
     * Set the value for name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * Get value of start.
    * @return the start
    */
    public Date getStart() {
        return start;
    }
    /**
     * Set the value for start.
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }
    /**
    * Get value of end.
    * @return the end
    */
    public Date getEnd() {
        return end;
    }
    /**
     * Set the value for end.
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }
    /**
    * Get value of time.
    * @return the time
    */
    public Date getTime() {
        return time;
    }
    /**
     * Set the value for time.
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
    /**
    * Get value of place.
    * @return the place
    */
    public String getPlace() {
        return place;
    }
    /**
     * Set the value for place.
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }
    /**
    * Get value of note.
    * @return the note
    */
    public String getNote() {
        return note;
    }
    /**
     * Set the value for note.
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
    * Get value of leader.
    * @return the leader
    */
    public String getLeader() {
        return leader;
    }
    /**
     * Set the value for leader.
     * @param leader the leader to set
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }
    
    
}
