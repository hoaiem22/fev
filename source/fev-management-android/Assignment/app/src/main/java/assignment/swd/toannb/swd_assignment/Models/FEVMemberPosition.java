package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;

public class FEVMemberPosition implements Serializable {
    private int id;
    private String position, note;
    private Collection<FEVMember>  fevMemberCollection;


    public FEVMemberPosition(int id, String position, String note, Collection<FEVMember> fevMemberCollection) {
        this.id = id;
        this.position = position;
        this.note = note;
        this.fevMemberCollection = fevMemberCollection;
    }

    public FEVMemberPosition(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public FEVMemberPosition(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
        return "FEVMemberPosition{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", note='" + note + '\'' +
                ", fevMemberCollection=" + fevMemberCollection +
                '}';
    }
}
