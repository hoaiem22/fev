package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;

public class FEVMemberStatus implements Serializable {
    private int id;
    private String status, note;
    private Collection<FEVMember> fevMemberCollection;

    public FEVMemberStatus() {
    }

    public FEVMemberStatus(int id, String status, String note, Collection<FEVMember> fevMemberCollection) {
        this.id = id;
        this.status = status;
        this.note = note;
        this.fevMemberCollection = fevMemberCollection;
    }

    public FEVMemberStatus(int id) {
        this.id = id;
    }

    public FEVMemberStatus(int id, String status) {
        this.id = id;
        this.status = status;
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

    public Collection<FEVMember> getFevMemberCollection() {
        return fevMemberCollection;
    }

    public void setFevMemberCollection(Collection<FEVMember> fevMemberCollection) {
        this.fevMemberCollection = fevMemberCollection;
    }


    @Override
    public String toString() {
        return "FEVMemberStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", fevMemberCollection=" + fevMemberCollection +
                '}';
    }
}
