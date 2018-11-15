package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVAccountRole implements Serializable {
    private int id;
    private String role, note;

    public FEVAccountRole(){

    }

    public FEVAccountRole(int id, String role, String note){
        this.id = id;
        this.role = role;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FEVAccountRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
