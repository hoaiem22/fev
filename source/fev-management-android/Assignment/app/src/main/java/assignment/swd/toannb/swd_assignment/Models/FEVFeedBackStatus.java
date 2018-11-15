package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;

public class FEVFeedBackStatus implements Serializable {

   private int id;
   private String status, note;
   private Collection<FEVFeedBack> fevFeedBackCollection;

    public FEVFeedBackStatus() {
    }

    public FEVFeedBackStatus(int id, String status, String note, Collection<FEVFeedBack> fevFeedBackCollection) {
        this.id = id;
        this.status = status;
        this.note = note;
        this.fevFeedBackCollection = fevFeedBackCollection;
    }

    public FEVFeedBackStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public FEVFeedBackStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<FEVFeedBack> getFevFeedBackCollection() {
        return fevFeedBackCollection;
    }

    public void setFevFeedBackCollection(Collection<FEVFeedBack> fevFeedBackCollection) {
        this.fevFeedBackCollection = fevFeedBackCollection;
    }

    @Override
    public String toString() {
        return "FEVFeedBackStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", fevFeedBackCollection=" + fevFeedBackCollection +
                '}';
    }
}
