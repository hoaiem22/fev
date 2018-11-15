package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVEventMember implements Serializable{

    private int id;
    private String note;
    private FEVMember fevMember;
    private FEVEvent fevEvent;


    public FEVEventMember() {
    }

    public FEVEventMember(int id, String note, FEVMember fevMember, FEVEvent fevEvent) {
        this.id = id;
        this.note = note;
        this.fevMember = fevMember;
        this.fevEvent = fevEvent;
    }

    public FEVEventMember(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FEVMember getFevMember() {
        return fevMember;
    }

    public void setFevMember(FEVMember fevMember) {
        this.fevMember = fevMember;
    }

    public FEVEvent getFevEvent() {
        return fevEvent;
    }

    public void setFevEvent(FEVEvent fevEvent) {
        this.fevEvent = fevEvent;
    }


    @Override
    public String toString() {
        return "FEVEventMember{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", fevMember=" + fevMember +
                ", fevEvent=" + fevEvent +
                '}';
    }
}
